package core.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int count = 0;
        int[] arr = new int[]{10, 10, 5, 3, 2, 2, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
//            System.out.println("HERE: " + j);
            for (; j >= 0; j--) {
//                System.out.println("ARR: " + arr[j]);
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];
                    count++;
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }
}
