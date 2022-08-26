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
