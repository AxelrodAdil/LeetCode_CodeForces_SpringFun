package leetcode.february2023;

public class BestTimeToBuyAndSellStock {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    public int maxProfit(int[] prices) {
        /*
        Runtime 2 ms
        Beats 63.52%
        Memory 59 MB
        Beats 64.97%
        */
        int minValue = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            if (price < minValue) minValue = price;
            else if (price - minValue > maxProfit) maxProfit = price - minValue;
        }
        return maxProfit;
    }
}
