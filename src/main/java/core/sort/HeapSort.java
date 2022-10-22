package core.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HeapSort {

    private void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    private void heapifyArray(int[] arr, int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < N && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < N && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapifyArray(arr, N, largest);
        }
    }

    private void sortArray( int[] arr) {
        int N = arr.length;
        IntStream.iterate(N / 2 - 1, i -> i >= 0, i -> i - 1).forEach(i -> heapifyArray(arr, N, i));
        IntStream.iterate(N - 1, i -> i > 0, i -> i - 1).forEach(i -> {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapifyArray(arr, i, 0);
        });
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        List<Integer> arrInteger = IntStream.range(0, 1_0).mapToObj(i -> (int) (Math.random() * 1_000)).collect(Collectors.toList());
        int[] arr = arrInteger.stream().mapToInt(Integer::intValue).toArray();
        heapSort.printArray(arr);
        System.out.println("--------------------------------------");
        heapSort.sortArray(arr);
        heapSort.printArray(arr);
    }
}
