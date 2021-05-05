package homework_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable{
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    private CountDownLatch cdlStart;
    private CountDownLatch cdlFinish;
    private CyclicBarrier cbStart;
    private Lock winnerLock;

    private static boolean winnerExist = false;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed,
               CountDownLatch cdlStart, CountDownLatch cdlFinish, CyclicBarrier cbStart, Lock winnerLock) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

        this.cdlStart = cdlStart;
        this.cdlFinish = cdlFinish;
        this.cbStart = cbStart;
        this.winnerLock = winnerLock;

    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cdlStart.countDown();
        }

        try {
            cbStart.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        winnerLock.lock();
        if (!winnerExist){
            System.out.println(name + " победил!");
            winnerExist = true;
        }
        winnerLock.unlock();

        cdlFinish.countDown();
    }
}
