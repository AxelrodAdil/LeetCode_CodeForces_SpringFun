package leetcode.december2022;

public class MinimumAverageDifference {

    // https://leetcode.com/problems/minimum-average-difference/

    public int minimumAverageDifference(int[] nums) {
        /*
        Runtime 18 ms
        Beats 88.29%
        Memory 60.2 MB
        Beats 95.27%
         */
        if (nums.length == 1) return 0;
        int id = -1;
        long min = Integer.MAX_VALUE;
        long sumLeft = nums[0];
        long sumRight = 0;
        for (int i = 1; i < nums.length; i++) {
            sumRight += nums[i];
        }
        int idAns = 0;
        int left = 1;
        int right = nums.length - left;
        var arr = new long[nums.length];
        for (int i = 1; i < nums.length; i++) {
            long diff = Math.abs((sumLeft / left) - (sumRight / right));
            arr[idAns] = diff;
            if (diff < min) {
                min = diff;
                id = idAns;
            }
            sumLeft += nums[i];
            sumRight -= nums[i];
            left++;
            right--;
            idAns++;
        }
        arr[idAns] = sumLeft / nums.length;
        if (arr[idAns] < min) {
            id = nums.length - 1;
        }
        return id;
    }
}
