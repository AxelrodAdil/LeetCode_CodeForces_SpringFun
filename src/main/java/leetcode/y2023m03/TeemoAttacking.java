package leetcode.y2023m03;

import java.util.stream.IntStream;

public class TeemoAttacking {

    // https://leetcode.com/problems/teemo-attacking/

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        /*
        Runtime 7 ms
        Beats 7%
        Memory 44.9 MB
        Beats 54.59%
        */
        if (duration == 0) return 0;
        int ans = IntStream.range(0, timeSeries.length - 1)
                .map(i -> Math.min(timeSeries[i + 1] - timeSeries[i], duration))
                .sum();
        return ans + duration;
    }
}
