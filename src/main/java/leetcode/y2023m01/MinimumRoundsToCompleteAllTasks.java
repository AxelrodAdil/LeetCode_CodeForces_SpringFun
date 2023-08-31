package leetcode.y2023m01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {

    // https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

    public int minimumRounds(int[] tasks) {
        /*
        Runtime 42 ms
        Beats 70.9%
        Memory 58.2 MB
        Beats 75.48%
         */
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(tasks).forEachOrdered(task -> map.put(task, map.getOrDefault(task, 0) + 1));
        int ans = 0;
        for (var amountOfTask : map.values()) {
            if (amountOfTask == 1) return -1;
            ans += (amountOfTask + 2) / 3;
        }
        return ans;
    }
}
