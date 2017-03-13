/**
 * 375. Guess Number Higher or Lower II
 * dp[i][j]: min money for [i,j]
 * dp[i][j] = min(k + max(dp[i][k-1], dp[k+1][j])), i <= k <= j
 * O(n^2)
 */
public class Solution {
    
    private int DP(int[][] dp, int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] != 0) return dp[start][end];
        int ans = Integer.MAX_VALUE;
        for (int k = start; k <= end; k++) {
            int tmp = k + Math.max(DP(dp, start, k-1), DP(dp, k+1, end));
            if (tmp < ans) ans = tmp;
        }
        dp[start][end] = ans;
        return ans;
    }
    
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        int[][] dp = new int[n+1][n+1];
        return DP(dp, 1, n);
    }
}