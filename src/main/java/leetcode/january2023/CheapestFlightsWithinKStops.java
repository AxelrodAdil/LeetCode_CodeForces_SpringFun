package leetcode.january2023;

import java.util.*;
import java.util.stream.Collectors;

public class CheapestFlightsWithinKStops {

    // https://leetcode.com/problems/cheapest-flights-within-k-stops/

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        /*
        Runtime 13 ms
        Beats 34.50%
        Memory 43.1 MB
        Beats 83.40%
        */
        var adj = Arrays.stream(flights)
                .collect(Collectors.groupingBy(i -> i[0], Collectors.mapping(i -> new int[]{i[1], i[2]}, Collectors.toList())));
        var dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> p = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        p.offer(new int[]{0, src, 0});
        while (!p.isEmpty()) {
            var curr = p.poll();
            int price = curr[0], place = curr[1], stop = curr[2];
            if (stop > dist[place] || stop > k + 1) continue;
            dist[place] = stop;
            if (place == dst) return price;
            if (!adj.containsKey(place)) continue;
            adj.get(place).stream().map(a -> new int[]{price + a[1], a[0], stop + 1}).forEach(p::offer);
        }
        return -1;
    }

    public int findCheapestPriceWrongAnswer(int n, int[][] flights, int src, int dst, int k) {
        // Wrong Answer: Output 3, Expected 6
        // 43 / 52 testcases passed
        var dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, k});
        while (!pq.isEmpty()) {
            var curr = pq.poll();
            int price = curr[0], place = curr[1], stop = curr[2];
            if (place == dst) return price;
            if (stop < 0) continue;
            Arrays.stream(flights).forEachOrdered(flight -> {
                int nPlace = flight[1], nPrice = flight[2];
                if (flight[0] == place && dist[place] + nPrice < dist[nPlace]) {
                    dist[nPlace] = dist[place] + nPrice;
                    pq.offer(new int[]{dist[nPlace], nPlace, stop - 1});
                }
            });
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
