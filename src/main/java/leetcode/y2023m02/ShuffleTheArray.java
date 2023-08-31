package leetcode.y2023m02;

public class ShuffleTheArray {

    // https://leetcode.com/problems/shuffle-the-array/

    public int[] shuffle(int[] nums, int n) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 42.6 MB
        Beats 51.87%
        */
        var ans = new int[nums.length];
        int k = n, j = 0;
        for (int i = 0; i < n; i++) {
            ans[j++] = nums[i];
            ans[j++] = nums[k++];
        }
        return ans;
    }

    public int[] shuffleSpace(int[] nums, int n) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 42.3 MB
        Beats 69.16%
        */
        var ans = new int[nums.length];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[n + i];
        }
        return ans;
    }
}
