package leetcode.level.medium.nospecifictopic;

import java.util.Arrays;

public class TheNumberOfWeakCharactersInTheGame {

    // https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/

    public int numberOfWeakCharacters(int[][] properties) {
        /*
        Runtime: 121 ms, faster than 81.67% of Java online submissions for The Number of Weak Characters in the Game.
        Memory Usage: 88.8 MB, less than 94.37% of Java online submissions for The Number of Weak Characters in the Game.
         */
        int ans = 0;
        Arrays.sort(properties, (a, b) -> (a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]));
        int max = Integer.MIN_VALUE;
        for (int[] i : properties) {
            if (i[1] < max) {
                ans++;
            }
            max = Math.max(max, i[1]);
        }
        return ans;
    }
}
