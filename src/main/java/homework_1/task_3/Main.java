package homework_1.task_3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>(1.0f);
        Box<Orange> orangeBox = new Box<>(1.5f);

        for (int i = 1; i <= 3; i++) {
            appleBox.putInBox(new Apple());
        }
        System.out.println("Вес коробки с яблоками " + appleBox.getWeight());

        orangeBox.putInBox(new Orange());
        System.out.println("Вес коробки с апельсинами " + orangeBox.getWeight());

        if(appleBox.compare(orangeBox)){
            System.out.println("Вес коробок одинаковый");
        } else {
            System.out.println("Вес коробок разный");
        }

        orangeBox.putInBox(new Orange());
        System.out.println("Вес коробки с апельсинами " + orangeBox.getWeight());
        if(appleBox.compare(orangeBox)){
            System.out.println("Вес коробок одинаковый");
        } else {
            System.out.println("Вес коробок разный");
        }

        System.out.println("\nB коробке " + appleBox.quantityInBox() + " яблок");
        Box<Apple> appleBox1 = new Box<>(1.0f);
        appleBox1.putInBox(new Apple());

        mergeBoxes(appleBox, appleBox1);
        System.out.println("B коробке " + appleBox.quantityInBox() + " яблок");


    }

    /**
     * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
     * @param box1 - коробка, куда пересыпаем
     * @param box2 - коробка, откуда пересыпаем
     */
    public static <M extends Fruit, N extends M> void mergeBoxes(Box<M> box1, Box<N> box2){
        ArrayList<N> boxArray = box2.getBoxArray();
        for(N fruit:boxArray){
            box1.putInBox(fruit);
        }
    }


}
