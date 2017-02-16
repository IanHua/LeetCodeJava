/**
 * 53. Maximum Subarray
 * DP
 * d(k): max sum of subarray ending at index k
 * d(k) = max(d(k - 1) + nums[k], nums[k])
 * O(n)
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxHere = nums[0], ans = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            maxHere = Math.max(nums[i], maxHere + nums[i]);
            ans = Math.max(ans, maxHere);
        }
        return ans;
    }
}