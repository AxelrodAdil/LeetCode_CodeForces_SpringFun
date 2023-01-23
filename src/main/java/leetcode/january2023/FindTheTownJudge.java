package leetcode.january2023;

import java.util.*;
import java.util.stream.IntStream;

public class FindTheTownJudge {

    // https://leetcode.com/problems/find-the-town-judge/

    public int findJudge(int n, int[][] trust) {
         /*
         Runtime 23 ms
         Beats 17.9%
         Memory 75.7 MB
         Beats 5.79%
         */
        var count = new int[n + 1];
        var map = new HashMap<Integer, Integer>();
        IntStream.range(0, trust.length).forEachOrdered(i -> {
            count[trust[i][1]]++;
            map.put(trust[i][0], 1);
        });
        return IntStream.rangeClosed(1, n).filter(i -> !map.containsKey(i))
                .filter(i -> count[i] == (n - 1)).findFirst().orElse(-1);
    }

    public int findJudgeArray(int n, int[][] trust) {
         /*
         Runtime 4 ms
         Beats 55.79%
         Memory 50.1 MB
         Beats 67.26%
         */
        var persons = new int[n];
        var judge = -1;
        IntStream.range(0, trust.length).forEachOrdered(i1 -> persons[trust[i1][1] - 1] += 1);
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == n - 1) {
                judge = i + 1;
                break;
            }
        }
        if (judge != -1) {
            for (var i : trust) {
                if (i[0] == judge) return -1;
            }
            return judge;
        }
        return -1;
    }
}
