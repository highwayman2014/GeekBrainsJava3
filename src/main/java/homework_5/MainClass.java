package homework_5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        CountDownLatch cdlStart = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdlFinish = new CountDownLatch(CARS_COUNT);
        CyclicBarrier cbStart = new CyclicBarrier(CARS_COUNT);
        Semaphore goToTunnelSemaphore = new Semaphore(CARS_COUNT/2);
        Lock winnerLock = new ReentrantLock();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(goToTunnelSemaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdlStart, cdlFinish, cbStart, winnerLock);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cdlStart.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cdlFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
