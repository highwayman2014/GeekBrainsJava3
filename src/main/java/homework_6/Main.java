package homework_6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static int[] getSubArrayAfterLastFour(int[] arr){
        if (arr == null || arr.length == 0){
            throw new RuntimeException("Array can't be empty or null");
        }
        int index = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == 4){
                index = i + 1;
                break;
            }
        }
        if(index == -1){
            throw new RuntimeException("Array must contain four");
        }
        int[] result = new int[arr.length - index];
        System.arraycopy(arr, index, result, 0, result.length);
        return result;
    }

    public static boolean arrayContainOneAndFour(int[] arr){
        return (Arrays.binarySearch(arr, 1) >= 0) && (Arrays.binarySearch(arr, 4) >= 0);
    }

}
