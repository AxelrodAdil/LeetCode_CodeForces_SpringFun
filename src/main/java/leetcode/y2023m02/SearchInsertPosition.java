package leetcode.y2023m02;

public class SearchInsertPosition {

    // https://leetcode.com/problems/search-insert-position/

    public int searchInsert(int[] nums, int target) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 42.3 MB
        Beats 14.1%
        */
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
