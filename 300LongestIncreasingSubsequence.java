/**
 * 300. Longest Increasing Subsequence
 * dp[i]: length of LIS upto position i
 * dp[i] = max(dp[j]) + 1
 * O(n^2)
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = dp[0];
        for (int i = 1; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] > max) max = dp[j];
                dp[i] = max + 1;
            }
            if (dp[i] > ans) ans = dp[i];
        }
        return ans;
    }
}