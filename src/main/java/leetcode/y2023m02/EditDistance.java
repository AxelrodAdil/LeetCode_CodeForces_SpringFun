package leetcode.y2023m02;

import java.util.stream.IntStream;

public class EditDistance {

    // https://leetcode.com/problems/edit-distance/

    public int minDistance(String word1, String word2) {
        /*
        Runtime 8 ms
        Beats 18.52%
        Memory 42.3 MB
        Beats 62.2%
        */
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        IntStream.rangeClosed(0, m).forEachOrdered(i -> dp[i][0] = i);
        IntStream.rangeClosed(0, n).forEachOrdered(j -> dp[0][j] = j);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1]
                        : 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }
}
