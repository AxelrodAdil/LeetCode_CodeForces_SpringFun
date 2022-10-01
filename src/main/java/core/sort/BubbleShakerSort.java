package core.sort;

import java.util.Arrays;

public class BubbleShakerSort {

    private static void printSortedArrayShaker(int[] array) {
        long timeMillis = System.currentTimeMillis();
        for (int i = 0; i < array.length / 2; i++) {
            boolean swapped = false;
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
//        System.out.println(Arrays.toString(array));
        System.out.println((double) (System.currentTimeMillis() - timeMillis));
    }


    private static void printSortedArray(int[] arr) {
        long timeMillis = System.currentTimeMillis();
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println((double) (System.currentTimeMillis() - timeMillis));
    }

    public void run(int[] arr) {
        printSortedArray(arr);
        System.out.println("\n\n---------Shaker---------");
        printSortedArrayShaker(arr);
    }
}
