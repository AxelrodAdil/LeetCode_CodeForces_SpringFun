package leetcode.march2023;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

    public int hashValue(String string, int RADIX, int MOD, int m) {
        int ans = 0;
        long factor = 1;
        for (int i = m - 1; i >= 0; i--) {
            ans += ((int) (string.charAt(i) - 'a') * factor) % MOD;
            factor = (factor * RADIX) % MOD;
        }
        return ans % MOD;
    }

    public int strStr(String haystack, String needle) {
        /*
        Runtime 1 ms
        Beats 41.61%
        Memory 40.7 MB
        Beats 30.23%
        */
        int m = needle.length(), n = haystack.length(), radix = 26, mod = 1000000033;
        if (n < m) return -1;
        long maxWeight = 1;
        for (int i = 0; i < m; i++) maxWeight = (maxWeight * radix) % mod;
        long hashNeedle = hashValue(needle, radix, mod, m), hashHay = 0;
        for (int windowStart = 0; windowStart <= n - m; windowStart++) {
            hashHay = windowStart == 0 ? hashValue(haystack, radix, mod, m)
                    : ((hashHay * radix) % mod - ((int) (haystack.charAt(windowStart - 1) - 'a')
                    * maxWeight) % mod + (int) (haystack.charAt(windowStart + m - 1) - 'a') + mod) % mod;
            if (hashNeedle == hashHay) {
                for (int i = 0; i < m; i++) {
                    if (needle.charAt(i) != haystack.charAt(i + windowStart)) break;
                    if (i == m - 1) return windowStart;
                }
            }
        }
        return -1;
    }

    public int strStrEasy(String haystack, String needle) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 40.2 MB
        Beats 67.86%
        */
        return haystack.indexOf(needle);
    }
}
