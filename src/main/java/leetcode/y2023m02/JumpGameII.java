package leetcode.y2023m02;

public class JumpGameII {

    // https://leetcode.com/problems/jump-game-ii/

    public int jump(int[] nums) {
        /*
        Runtime 1 ms
        Beats 99.51%
        Memory 44.1 MB
        Beats 8.17%
        */
        int max = 0, current = 0, ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (current == i) {
                current = max;
                ans++;
            }
            if (current > nums.length - 1) return ans;
        }
        return ans;
    }
}
