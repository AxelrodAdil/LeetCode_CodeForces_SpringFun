package leetcode.march;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips {

    // https://leetcode.com/problems/minimum-time-to-complete-trips/

    boolean canComplete(int[] time, long givenTime, long totalTrips) {
        var trips = Arrays.stream(time).mapToLong(t -> givenTime / t).sum();
        return trips >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {
        /*
        TODO later...
        Runtime 481 ms
        Beats 5.23%
        Memory 56 MB
        Beats 88.67%
        */
        var min = Arrays.stream(time).asLongStream().min().orElse(Long.MAX_VALUE);
        long s = 1, e = min * totalTrips;
        while (s < e) {
            var m = s + (e - s) / 2;
            if (canComplete(time, m, totalTrips)) e = m;
            else s = m + 1;
        }
        return s;
    }
}
