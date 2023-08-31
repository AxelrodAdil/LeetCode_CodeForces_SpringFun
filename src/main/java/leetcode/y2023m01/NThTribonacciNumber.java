package leetcode.y2023m01;

public class NThTribonacciNumber {

    // https://leetcode.com/problems/n-th-tribonacci-number/

    public int tribonacci(int n) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 39.1 MB
        Beats 61.90%
        */
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int t0 = 0, t1 = 1, t2 = 1, tn = 0;
        for (int i = 3; i <= n; i++) {
            tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        return tn;
    }
}
