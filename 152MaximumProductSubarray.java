/**
 * 152. Maximum Product Subarray
 * DP
 * f(k): max product of subarray ending at index k
 * g(k): min product of subarray ending at index k
 * f(k) = max(nums[k], f(k-1)*nums[k], g(k-1)*nums[k])
 * g(k) = min(nums[k], f(k-1)*nums[k], g(k-1)*nums[k])
 * O(n)
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        int max = nums[0], min = nums[0], ans = nums[0];
        int mx, mn;
        for (int i = 1; i < len; i++) {
            mx = max;
            mn = min;
            max = Math.max(nums[i], Math.max(mx * nums[i], mn * nums[i]));
            min = Math.min(nums[i], Math.min(mx * nums[i], mn * nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}