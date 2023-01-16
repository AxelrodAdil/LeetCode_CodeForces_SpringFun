package leetcode.january2023;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    // https://leetcode.com/problems/insert-interval/

    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        Runtime 1 ms
        Beats 99.26%
        Memory 44.1 MB
        Beats 99.39%
        */
        int index = 0;
        List<int[]> result = new ArrayList<>();
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index++]);
        }
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        result.add(newInterval);
        while (index < intervals.length) {
            result.add(intervals[index++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}
