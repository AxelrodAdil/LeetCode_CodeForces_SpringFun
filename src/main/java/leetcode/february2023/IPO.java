package leetcode.february2023;

import java.util.*;
import java.util.stream.IntStream;

public class IPO {

    // https://leetcode.com/problems/ipo/

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        /*
        Runtime 137 ms
        Beats 25.76%
        Memory 63.1 MB
        Beats 18.13%
        */
        var l = new int[capital.length][2];
        var i = 0;
        IntStream.range(0, l.length).forEachOrdered(j -> {
            l[j][0] = capital[j];
            l[j][1] = profits[j];
        });
        Arrays.sort(l, Comparator.comparingInt(e -> e[0]));
        Queue<Integer> res = new PriorityQueue<>(Collections.reverseOrder());
        while (k-- > 0) {
            for (; i < l.length && l[i][0] <= w; i++) res.add(l[i][1]);
            if (res.isEmpty()) break;
            w += res.poll();
        }
        return w;
    }
}
