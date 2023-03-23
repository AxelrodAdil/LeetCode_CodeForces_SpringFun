package leetcode.march2023;

public class CheckIfNumberIsASumOfPowersOfThree {

    // https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

    public boolean checkPowersOfThree(int n) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 39.4 MB
        Beats 50.18%
        */
        for (int i = 19; i >= 0; i--) {         // 3^19*2-19
            int temp = (int) Math.pow(3, i);
            if (temp <= n) n -= temp;
            if (n == 0) return true;
        }
        return false;
    }
}
