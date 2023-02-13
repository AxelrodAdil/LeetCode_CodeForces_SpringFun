package leetcode.level.easy.nospecifictopic;

public class SqrtX {

    // https://leetcode.com/problems/sqrtx/

    public int mySqrt(int x) {
        /*
        Runtime: 1 ms, faster than 100.00% of Java online submissions for Sqrt(x).
        Memory Usage: 39.4 MB, less than 96.80% of Java online submissions for Sqrt(x).
        */
        return x <= 1 ? x : (int) Math.floor(Math.sqrt(x));
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(8));
    }
}
