package leetcode.january2023;

import java.util.Arrays;

public class MaximumIceCreamBars {

    // https://leetcode.com/problems/maximum-ice-cream-bars/

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            coins -= cost;
            if (coins < 0) { return count; }
            else { count++; }
        }
        return count;
    }
}
