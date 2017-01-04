/*
 * Best Time to Buy and Sell Stock
 * max(prices[j] - prices[i])
 * Iterate the array once, prices[i] must be the minPrice at that time, 
 * so define two variables minPrice and maxProfit. Update maxProfit if 
 * there is a larger value.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int i, len = prices.length;
        for (i = 0; i < len; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}