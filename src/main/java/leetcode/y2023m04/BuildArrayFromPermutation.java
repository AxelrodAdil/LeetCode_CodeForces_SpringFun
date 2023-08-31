package leetcode.y2023m04;

import java.util.Arrays;

public class BuildArrayFromPermutation {

    // https://leetcode.com/problems/build-array-from-permutation/

    public int[] buildArray(int[] nums) {
        /*
        Runtime 5 ms
        Beats 98.3%
        Memory 43 MB
        Beats 63.84%
        */
        return Arrays.stream(nums).map(num -> nums[num]).toArray();
    }
}
