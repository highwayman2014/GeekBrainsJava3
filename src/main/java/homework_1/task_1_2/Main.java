package homework_1.task_1_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Задание 1

        String[] arr = new String[4];
        Arrays.fill(arr, "a");
        arr[1] = "b";
        arr[3] = "c";
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        arr = changeElementsPosition(arr, 1, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        Integer[] arr1 = new Integer[4];
        Arrays.fill(arr1, 0);
        arr1[0] = 1;
        arr1[1] = 2;
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
        }
        System.out.println();

        arr1 = changeElementsPosition(arr1, 0, 3);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
        }
        System.out.println();

        // Задание 2
        ArrayList<String> arrayList1 = arrayToArrayList(arr);
        ArrayList<Integer> arrayList2 = arrayToArrayList(arr1);

    }

    /**  Задание 1
     *  Метод меняет местами элементы массива
     *  Массив может быть любого ссылочного типа
     */
    public static <T extends Object> T[] changeElementsPosition(T[]arr, int position1, int position2){
        T buffer;
        buffer = arr[position2];
        arr[position2] = arr[position1];
        arr[position1] = buffer;

        return arr;
    }

    /** Задание 2
     * Метод преобразует массив любого ссылочного типа в ArrayList
     */
    public static <T extends Object> ArrayList<T> arrayToArrayList(T[]arr){
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        return arrayList;
    }



}
