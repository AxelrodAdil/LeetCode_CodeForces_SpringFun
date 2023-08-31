package leetcode.y2023m01;

import java.util.Arrays;
import java.util.HashMap;

public class MaxPointsOnALine {

    // https://leetcode.com/problems/max-points-on-a-line/

    public int maxPoints(int[][] points) {
        /*
        Runtime 21 ms
        Beats 88.80%
        Memory 42.5 MB
        Beats 72.10%
         */
        int max = 0;
        for (var point1 : points) {
            var map = new HashMap<Double, Integer>();
            Arrays.stream(points).filter(point2 -> point1 != point2).forEachOrdered(point2 -> {
                int dy = point1[1] - point2[1];
                double slope = dy != 0 ? ((double) dy) / (point1[0] - point2[0]) : Double.MAX_VALUE;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            });
            for (int val : map.values()) max = Math.max(val, max);
        }
        return max + 1;
    }
}
