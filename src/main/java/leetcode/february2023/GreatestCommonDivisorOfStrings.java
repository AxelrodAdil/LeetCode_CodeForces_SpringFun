package leetcode.february2023;

public class GreatestCommonDivisorOfStrings {

    // https://leetcode.com/problems/greatest-common-divisor-of-strings/

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public String gcdOfStrings(String str1, String str2) {
        /*
        Runtime 1 ms
        Beats 85.83%
        Memory 41.9 MB
        Beats 82.48%
        */
        if (!(str1.concat(str2).equals(str2.concat(str1)))) return "";
        int ans = gcd(str1.length(), str2.length());
        return str1.substring(0, ans);
    }
}
