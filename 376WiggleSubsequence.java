/**
 * 376. Wiggle Subsequence
 * Space-optimized dp
 * up/down: max length of wiggle subsequence before (include) current pos
 * O(n)
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int up = 1, down = 1;
        for (int i = 1; i< len; i++) {
            if (nums[i] > nums[i-1]) {
                up = down + 1;
            } else if (nums[i] < nums[i-1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}