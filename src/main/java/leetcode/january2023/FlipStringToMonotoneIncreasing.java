package leetcode.january2023;

public class FlipStringToMonotoneIncreasing {

    // https://leetcode.com/problems/flip-string-to-monotone-increasing/

    public int minFlipsMonoIncr(String s) {
        /*
        Runtime 10 ms
        Beats 84.7%
        Memory 42.9 MB
        Beats 77.97%
        */
        int ans = 0;
        int flips = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                ans = Math.min(flips, ans + 1);
            } else {
                flips++;
            }
        }
        return ans;
    }
}
