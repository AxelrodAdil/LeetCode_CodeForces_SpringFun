package leetcode.y2023m01;

public class GasStation {

    // https://leetcode.com/problems/gas-station/

    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        Runtime 2 ms
        Beats 66.30%
        Memory 62.6 MB
        Beats 45.63%
        */
        int tank = 0, ans = 0, gasSum = 0, costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                ans = i + 1;
            }
            gasSum += gas[i];
            costSum += cost[i];
        }
        return (gasSum >= costSum) ? ans : -1;
    }
}
