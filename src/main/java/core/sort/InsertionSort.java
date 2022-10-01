package core.sort;

import java.util.Arrays;

public class InsertionSort {

    private static int findElement(Integer[] arr, Integer element) {
        int count = 0;
        for (int i : arr) {
            if (element.equals(i)) {
                return count;
            }
            count++;
        }
        return -1;
    }

    private static int[] getSortedArrayAsc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
        return arr;
    }

    private static int[] getSortedArrayDesc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value > arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
        return arr;
    }

    public void run(int[] arr) {
        long l1 = System.currentTimeMillis();
        int[] arrAsc = getSortedArrayAsc(arr);
//        System.out.println(Arrays.toString(arrAsc));
        System.out.println((double) (System.currentTimeMillis() - l1));

        long l2 = System.currentTimeMillis();
        int[] arrDesc = getSortedArrayDesc(arr);
//        System.out.println(Arrays.toString(arrDesc));
        System.out.println((double) (System.currentTimeMillis() - l2));
    }
}
