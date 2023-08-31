package leetcode.y2023m01;

public class MaximumSumCircularSubarray {

    // https://leetcode.com/problems/maximum-sum-circular-subarray/

    public int maxSubarraySumCircular(int[] nums) {
        /*
        Runtime 4 ms
        Beats 82.72%
        Memory 47.5 MB
        Beats 73.4%
        */
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        int currMax = 0, currMin = 0, sum = 0;
        for (int el : nums) {
            currMax = Math.max(currMax + el, el);
            currMin = Math.min(currMin + el, el);
            maxSum = Math.max(maxSum, currMax);
            minSum = Math.min(minSum, currMin);
            sum += el;
        }
        return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
    }
}
