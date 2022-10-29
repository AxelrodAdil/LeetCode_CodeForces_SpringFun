package core.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSort {

    private static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    private static void mergeArray(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray;
        System.arraycopy(arr, left, leftArray, 0, n1);
        rightArray = IntStream.range(0, n2).map(j -> arr[mid + 1 + j]).toArray();
        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void sortArray(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sortArray(arr, left, mid);
            sortArray(arr, mid + 1, right);
            mergeArray(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        List<Integer> arrInteger = IntStream.range(0, 1_0).mapToObj(i -> (int) (Math.random() * 1_000)).collect(Collectors.toList());
        int[] arr = arrInteger.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));

        long l1 = System.currentTimeMillis();
        sortArray(arr, 0, arr.length - 1);
        printArray(arr);
        System.out.println((double) (System.currentTimeMillis() - l1));
    }
}
