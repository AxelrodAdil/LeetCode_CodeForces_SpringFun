package leetcode.january2023;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BestTeamWithNoConflicts {

    // https://leetcode.com/problems/best-team-with-no-conflicts/

    public int bestTeamScore(int[] scores, int[] ages) {
        /*
        Runtime 47 ms
        Beats 68.71%
        Memory 42.6 MB
        Beats 64.63%
        */
        int[][] players = IntStream.range(0, scores.length).mapToObj(i -> new int[]{ages[i], scores[i]}).toArray(int[][]::new);
        Arrays.sort(players, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[scores.length];
        int ans = 0;
        for (int i = 0; i < scores.length; i++) {
            dp[i] = players[i][1];
            for (int j = 0; j < i; j++) {
                if (players[j][1] <= players[i][1]) dp[i] = Math.max(dp[i], dp[j] + players[i][1]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
