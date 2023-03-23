package leetcode.march2023;

public class PowerOfTwo {

    // https://leetcode.com/problems/power-of-two/

    public boolean isPowerOfTwo(int n) {
        /*
        Runtime 1 ms
        Beats 100%
        Memory 40.2 MB
        Beats 17.38%
        */
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
