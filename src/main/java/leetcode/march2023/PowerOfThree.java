package leetcode.march2023;

public class PowerOfThree {

    // https://leetcode.com/problems/power-of-three/

    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        return 1162261467%n==0;     // 3^19
    }

    public boolean isPowerOfThreeLog3N(int n) {
        /*
        Runtime 16 ms
        Beats 43.71%
        Memory 42.7 MB
        Beats 20.4%
        */
        if (n <= 0) return false;
        while (n >= 3) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return n == 1;
    }
}
