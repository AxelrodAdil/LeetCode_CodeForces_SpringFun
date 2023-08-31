package leetcode.y2023m03;

public class PowerOfFour {

    // https://leetcode.com/problems/power-of-four/

    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;

        // 4 16 64 256 1024
        return (n & (n - 1)) == 0 && (n % 3 == 1);
    }
}
