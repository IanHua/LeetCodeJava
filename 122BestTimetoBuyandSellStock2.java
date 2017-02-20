/**
 * 122. Best Time to Buy and Sell Stock II
 * Just sum up the difference of adjacent numbers which are non-decreased
 * O(n)
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int i;
        int ans = 0;
        for (i = 1; i < len; i++) {
            if (prices[i-1] <= prices[i]) {
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }
}