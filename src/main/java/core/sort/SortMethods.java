package core.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortMethods {

    private static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> arrInteger = IntStream.range(0, 10_000).mapToObj(i -> (int) (Math.random() * 1_000)).collect(Collectors.toList());
        int[] arr = arrInteger.stream().mapToInt(Integer::intValue).toArray();
//        printArray(arr, arr.length);

        System.out.println("\n\n---------Bubble---------");
        BubbleShakerSort bubbleShakerSort = new BubbleShakerSort();
        bubbleShakerSort.run(arr);
        System.out.println("\n\n---------Quick---------");
        QuickSort quickSort = new QuickSort();
        quickSort.run(arr);
        System.out.println("\n\n---------Insertion---------");
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.run(arr);
    }
}
