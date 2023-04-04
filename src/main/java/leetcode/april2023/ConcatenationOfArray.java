package leetcode.april2023;

public class ConcatenationOfArray {

    // https://leetcode.com/problems/concatenation-of-array/

    public int[] getConcatenation(int[] nums) {
        /*
        Runtime 1 ms
        Beats 93.70%
        Memory 42.9 MB
        Beats 77.14%
        */
        var ans = new int[nums.length + nums.length];
        var id = 0;
        for (int i = 0; i < ans.length; i++) {
            if (nums.length == i) id = 0;
            ans[i] = nums[id++];
        }
        return ans;
    }
}
