package leetcode.january2023;

import java.util.*;
import java.util.stream.IntStream;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {

    // https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

    private int[] dfs(Map<Integer, List<Integer>> adj, Set<Integer> visitedSet, String labels, int node, int[] ans) {
        int[] count = new int[26];
        if (visitedSet.add(node)) {
            char character = labels.charAt(node);
            List<Integer> childList = adj.getOrDefault(node, new ArrayList<>());
            childList.stream().mapToInt(child -> child)
                    .mapToObj(child -> dfs(adj, visitedSet, labels, child, ans))
                    .forEachOrdered(
                            res -> IntStream.range(0, 26).forEachOrdered(i -> count[i] += res[i])
                    );
            count[character - 'a']++;
            ans[node] = count[character - 'a'];
        }
        return count;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        /*
        Runtime 383 ms
        Beats 22.82%
        Memory 302.4 MB
        Beats 5.43%
        */
        int[] ans = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Arrays.stream(edges).forEachOrdered(e -> {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        });
        Set<Integer> visitedSet = new HashSet<>();
        dfs(adj, visitedSet, labels, 0, ans);
        return ans;
    }
}
