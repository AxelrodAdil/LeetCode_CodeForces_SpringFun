package leetcode.february2023;

import java.util.Arrays;

public class SingleElementInASortedArray {

    // https://leetcode.com/problems/single-element-in-a-sorted-array/

    public int singleNonDuplicate(int[] nums) {
        /*
        Runtime 3 ms
        Beats 7.49%
        Memory 48.1 MB
        Beats 72.85%
        */
        return Arrays.stream(nums).reduce(0, (a1, b) -> a1 ^ b);
    }
}
