package homework_3;

public class Main {
    public static void main(String[] args) {

        PrintClass printClass = new PrintClass();
        Thread threadA = new Thread(()->{
            printClass.PrintA();
        });
        Thread threadB = new Thread(()->{
            printClass.PrintB();
        });
        Thread threadC = new Thread(()->{
            printClass.PrintC();
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }


}
