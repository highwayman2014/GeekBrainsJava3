package homework_5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage{
    private Semaphore goToTunnelSemaphore;
    public Tunnel(Semaphore goToTunnelSemaphore) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.goToTunnelSemaphore = goToTunnelSemaphore;
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                goToTunnelSemaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                goToTunnelSemaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
