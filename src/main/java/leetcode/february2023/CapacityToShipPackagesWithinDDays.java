package leetcode.february2023;

public class CapacityToShipPackagesWithinDDays {

    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

    public int shipWithinDays(int[] weights, int days) {
        /*
        Runtime 108 ms
        Beats 5.12%
        Memory 54.6 MB
        Beats 5.90%
        */
        int total = 0, maxWeight = Integer.MIN_VALUE;
        for (var w : weights) {
            total += w;
            maxWeight = Math.max(maxWeight, w);
        }
        if (days == 1) return total;
        if (days == weights.length) return maxWeight;
        var cap = (int) Math.ceil((double) total / days);
        while (!canShip(weights, days, 0, cap)) cap++;
        return cap;
    }

    private boolean canShip(int[] weights, int days, int start, int cap) {
        if (days == 0) return start >= weights.length;
        int shipped = 0, i = start;
        while (i < weights.length) {
            shipped += weights[i];
            if (shipped > cap) break;
            i++;
        }
        return i == weights.length || canShip(weights, days - 1, i, cap);
    }
}
