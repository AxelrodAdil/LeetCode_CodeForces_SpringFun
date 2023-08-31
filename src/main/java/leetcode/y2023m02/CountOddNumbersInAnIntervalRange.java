package leetcode.y2023m02;

public class CountOddNumbersInAnIntervalRange {

    // https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

    public int countOdds(int low, int high) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 39.3 MB
        Beats 43.83%
        */
        if (low % 2 == 0) low++;
        if (high % 2 == 0) high--;
        return ((high - low) >> 1) + 1;
    }
}
