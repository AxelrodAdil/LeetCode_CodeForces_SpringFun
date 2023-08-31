package leetcode.y2023m02;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimizeDeviationInArray {

    // https://leetcode.com/problems/minimize-deviation-in-array/

    public int minimumDeviation(int[] nums) {
        /*
        Runtime 854 ms
        Beats 5.66%
        Memory 104.6 MB
        Beats 5.66%
        */
        int ans = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) nums[i] *= 2;
            min = Math.min(min, nums[i]);
            pq.add(nums[i]);
        }
        while (pq.peek() % 2 == 0) {
            var one = pq.remove();
            ans = Math.min(one - min, ans);
            min = Math.min(one / 2, min);
            pq.add(one / 2);
        }
        ans = Math.min(pq.peek() - min, ans);
        return ans;
    }
}
