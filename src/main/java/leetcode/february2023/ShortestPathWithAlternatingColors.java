package leetcode.february2023;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShortestPathWithAlternatingColors {

    // https://leetcode.com/problems/shortest-path-with-alternating-colors/

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        /*
        Runtime 12 ms
        Beats 10.10%
        Memory 43.5 MB
        Beats 10.50%
        */
        List<List<Integer>> adj_red = IntStream.range(0, n).<List<Integer>>mapToObj(i -> new ArrayList<>())
                .collect(Collectors.toList());
        Arrays.stream(redEdges).forEachOrdered(e -> adj_red.get(e[0]).add(e[1]));
        List<List<Integer>> adj_blue = IntStream.range(0, n)
                .<List<Integer>>mapToObj(i -> new ArrayList<>()).collect(Collectors.toList());
        Arrays.stream(blueEdges).forEachOrdered(e -> adj_blue.get(e[0]).add(e[1]));
        var dist_red = IntStream.range(0, n).map(i -> Integer.MAX_VALUE).toArray();
        var dist_blue = IntStream.range(0, n).map(i -> Integer.MAX_VALUE).toArray();
        dist_red[0] = 0;
        dist_blue[0] = 0;
        PriorityQueue<PairShortestPathWithAlternatingColors> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new PairShortestPathWithAlternatingColors(0, 'b', 0));
        pq.add(new PairShortestPathWithAlternatingColors(0, 'r', 0));
        while (!pq.isEmpty()) {
            PairShortestPathWithAlternatingColors temp = pq.poll();
            int v = temp.node, d = temp.dist;
            ;
            char prev = temp.prev;
            if (prev == 'r') {
                for (var x : adj_blue.get(v)) {
                    if (d + 1 < dist_blue[x]) {
                        dist_blue[x] = d + 1;
                        pq.add(new PairShortestPathWithAlternatingColors(x, 'b', d + 1));
                    }
                }
            } else {
                for (var x : adj_red.get(v)) {
                    if (d + 1 < dist_red[x]) {
                        dist_red[x] = d + 1;
                        pq.add(new PairShortestPathWithAlternatingColors(x, 'r', d + 1));
                    }
                }
            }
        }
        var ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(dist_red[i], dist_blue[i]);
            if (ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }
        return ans;
    }
}

class PairShortestPathWithAlternatingColors {
    int node, dist;
    char prev;

    public PairShortestPathWithAlternatingColors(int n, char p, int d) {
        node = n;
        prev = p;
        dist = d;
    }
}
