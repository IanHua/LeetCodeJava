/**
 * 477. Total Hamming Distance
 * Bit-wise add
 * O(n)
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int len = nums.length;
        int ans = 0;
        int i, j, cnt;
        for (i = 0; i < 32; i++) {
            cnt = 0;
            for (j = 0; j < len; j++) {
                cnt += (nums[j] >> i) & 1;
            }
            ans += cnt * (len - cnt);
        }
        return ans;
    }
}