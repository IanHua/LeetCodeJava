/*
 * 198. House Robber
 * Dynamic Programming
 * d[i]: the max money upto house i
 * d[i+1] = max(d[i], d[i-1]+nums[i+1])
 * O(n)
 */
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length, i;
        if (len == 0) {
            return 0;
        }
        else if (len == 1) {
            return nums[0];
        }
        int[] d = new int[len];
        d[0] = nums[0];
        d[1] = Math.max(nums[0], nums[1]);
        for (i = 2; i < len; i++) {
            d[i] = Math.max(d[i-1], d[i-2]+nums[i]);
        }
        return d[len-1];
    }
}