package core.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearch {

    private static int binarySearch(int[] arr, int left, int right, int x) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) return mid;
            return x >= arr[mid] ? binarySearch(arr, mid + 1, right, x) : binarySearch(arr, left, mid - 1, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arrInteger = IntStream.range(0, 1_0).mapToObj(i -> (int) (Math.random() * 1_000)).collect(Collectors.toList());
        int[] arr = arrInteger.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));
        int findElement = arr[5];
        Arrays.sort(arr);
//        int findElement = 7;
        System.out.println(Arrays.toString(arr));
        int result = binarySearch(arr, 0, arr.length - 1, findElement);
        System.out.println(result == -1 ? "Not exist" : "index " + result + " - " + arr[result]);
    }
}
