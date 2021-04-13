package homework_1.task_3;

import java.util.ArrayList;

/**
 * b. Класс Box в который можно складывать фрукты,
 * коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины
 */
public class Box<T extends Fruit> {

    // c. Для хранения фруктов внутри коробки можете использовать ArrayList
    private ArrayList<T> boxArray;

    private float unitWeight;

    public Box(float unitWeight) {
        this.unitWeight = unitWeight;
        this.boxArray = new ArrayList<>();
    }

    public float getUnitWeight() {
        return unitWeight;
    }

    public int quantityInBox(){
        return boxArray.size();
    }

    /**
     * d. Сделать метод getWeight() который высчитывает вес коробки
     */
    public float getWeight(){
        return this.quantityInBox() * this.getUnitWeight();
    }

    /**
     * e. Внутри класса коробка сделать метод compare,
     * который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра,
     * true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами)
     */
    public boolean compare(Box<? extends Fruit> otherBox){
        return getWeight() == otherBox.getWeight();
    }

    public ArrayList<T> getBoxArray(){
        return boxArray;
    }

    /**
     * g. Не забываем про метод добавления фрукта в коробку
     */
    public void putInBox(T fruit){
        boxArray.add(fruit);
    }

}
