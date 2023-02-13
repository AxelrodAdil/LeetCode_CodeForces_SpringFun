package leetcode.level.easy.bitmanipulation;

public class SingleNumber {

    // https://leetcode.com/problems/single-number/

    public int singleNumber(int[] nums) {
        /*
        Runtime: 2 ms, faster than 64.50% of Java online submissions for Single Number.
        Memory Usage: 50.5 MB, less than 58.97% of Java online submissions for Single Number.
        */
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
