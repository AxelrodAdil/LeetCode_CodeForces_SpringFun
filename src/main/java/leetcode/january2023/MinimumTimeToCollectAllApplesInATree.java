package leetcode.january2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {

    // https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

    private int dfs(HashMap<Integer, List<Integer>> tree, List<Boolean> appleList, int start, boolean[] visited) {
        visited[start] = true;
        var totalTime = tree.get(start).stream().mapToInt(ele -> ele)
                .filter(ele -> !visited[ele])
                .map(ele -> dfs(tree, appleList, ele, visited)).sum();
        if (start != 0 && (appleList.get(start) || totalTime > 0)) totalTime = totalTime + 2;
        return totalTime;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        /*
        Runtime 116 ms
        Beats 26.47%
        Memory 92.9 MB
        Beats 31.77%
        */
        var tree = new HashMap<Integer, List<Integer>>();
        Arrays.stream(edges).forEachOrdered(edge -> {
            tree.putIfAbsent(edge[0], new LinkedList<>());
            tree.putIfAbsent(edge[1], new LinkedList<>());
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        });
        boolean[] visited = new boolean[n];
        return dfs(tree, hasApple, 0, visited);
    }
}
