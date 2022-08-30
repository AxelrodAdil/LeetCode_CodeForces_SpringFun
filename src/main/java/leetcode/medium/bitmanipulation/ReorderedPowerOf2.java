package leetcode.medium.bitmanipulation;

import java.util.Arrays;

public class ReorderedPowerOf2 {

    // https://leetcode.com/problems/reordered-power-of-2/

    private int[] getIntArray(int n) {
        int[] arr = new int[10];
        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
        }
        return arr;
    }

    public boolean reorderedPowerOf2(int n) {
        /*
        Runtime: 2 ms, faster than 68.67% of Java online submissions for Reordered Power of 2.
        Memory Usage: 40.9 MB, less than 71.33% of Java online submissions for Reordered Power of 2.
        */
        int[] arr = getIntArray(n);
        for (int i = 0; i < 32; i++) {
            if (Arrays.equals(arr, getIntArray(1 << i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ReorderedPowerOf2 reorderedPowerOf2 = new ReorderedPowerOf2();
        System.out.println(reorderedPowerOf2.reorderedPowerOf2(10));
        System.out.println(reorderedPowerOf2.reorderedPowerOf2(25));
    }
}
