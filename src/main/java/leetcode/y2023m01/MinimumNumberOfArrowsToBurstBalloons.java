package leetcode.y2023m01;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    // https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

    public int findMinArrowShots(int[][] points) {
        /*
        Runtime 786 ms
        Beats 5.3%
        Memory 125.6 MB
        Beats 5.11%
         */
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int minimumArrows = 1;
        int prev = points[0][1];
        for (int i = 1; i < points.length; i++) {
            System.out.println(points[i][0] + " - " + points[i][1]);
            if (points[i][0] > prev) {
                minimumArrows++;
                prev = points[i][1];
            } else {
                prev = Math.min(prev, points[i][1]);
            }
        }
        return minimumArrows;
    }
}
