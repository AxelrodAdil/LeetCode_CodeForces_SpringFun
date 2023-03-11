package leetcode.march2023;

import java.util.Arrays;

public class SortAnArray {

    // https://leetcode.com/problems/sort-an-array/

    private void countingSort(int[] nums) {
        int max = -5000, min = 5000, j = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        var counts = new int[max - min + 1];
        for (var num : nums) {
            counts[num - min]++;
        }
        for (int i = min; i <= max; i++) {
            while (counts[i - min] > 0) {
                nums[j++] = i;
                counts[i - min]--;
            }
        }
    }

    public int[] sortArray(int[] nums) {
        /*
        Runtime 4 ms
        Beats 99.27%
        Memory 51.3 MB
        Beats 95.40%
        */
        countingSort(nums);
        return nums;
    }

    public int[] sortArrayWithDualPivotQuicksort(int[] nums) {
        /*Runtime 17 ms
        Beats 88.98%
        Memory 51.8 MB
        Beats 84.65%
        */
        // worst case: O(n^2)
        Arrays.sort(nums);
        return nums;
    }
}
