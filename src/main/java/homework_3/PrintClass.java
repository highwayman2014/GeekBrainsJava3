package homework_3;

public class PrintClass{

    char currentLetter = 'A';

    public synchronized void PrintA(){
        for (int i = 0; i < 5; i++) {
            while(currentLetter != 'A'){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("A");
            currentLetter = 'B';
            notifyAll();
        }
    }

    public synchronized void PrintB(){
        for (int i = 0; i < 5; i++) {
            while(currentLetter != 'B'){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("B");
            currentLetter = 'C';
            notifyAll();
        }
    }

    public synchronized void PrintC(){
        for (int i = 0; i < 5; i++) {
            while(currentLetter != 'C'){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("C");
            currentLetter = 'A';
            notifyAll();
        }
    }
}
