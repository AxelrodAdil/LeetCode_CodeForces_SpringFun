package leetcode.march2023;

public class KthMissingPositiveNumber {

    // https://leetcode.com/problems/kth-missing-positive-number/

    public int findKthPositive(int[] arr, int k) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 42 MB
        Beats 48.77%
        */
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int temp = k - arr[mid] + mid;
            if (temp >= 0) left = mid + 1;
            else right = mid - 1;
        }
        return k + left;
    }
}
