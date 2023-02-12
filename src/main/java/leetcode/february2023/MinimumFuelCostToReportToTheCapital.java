package leetcode.february2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MinimumFuelCostToReportToTheCapital {

    // https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/

    private long[] minimumFuelCost(HashMap<Integer, ArrayList<Integer>> map, int curr, int seats, HashSet<Integer> visited) {
        long sum = 0, size = 0;
        for (int i : map.get(curr)) {
            if (visited.contains(i)) continue;
            visited.add(i);
            long[] temp = minimumFuelCost(map, i, seats, visited);
            sum += temp[0];
            size += temp[1];
        }
        return size == 0 ? new long[]{1, 1} : new long[]{sum + (int) Math.ceil((double) (size + 1) / seats), size + 1};
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        /*
        Runtime 160 ms
        Beats 20.20%
        Memory 116.5 MB
        Beats 35.18%
        */
        if (roads.length == 0 || roads.length == 1) return roads.length;
        var map = new HashMap<Integer, ArrayList<Integer>>();
        Arrays.stream(roads).forEachOrdered(road -> {
            map.computeIfAbsent(road[0], l -> new ArrayList<>());
            map.computeIfAbsent(road[1], l -> new ArrayList<>());
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        });
        var visited = new HashSet<Integer>();
        visited.add(0);
        long res = 0;
        for (int i : map.get(0)) {
            visited.add(i);
            res += minimumFuelCost(map, i, seats, visited)[0];
        }
        return res;
    }
}
