/** 
 * 338. Counting Bits
 * The bit pattern of current range is the whole patterns of previous ranges
 * O(n)
 */
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;
        if (num == 0) {
            return ans;
        }
        ans[1] = 1;
        if (num == 1) {
            return ans;
        }
        int i, idx = 2;
        for (i = 2; i <= num; i++) {
            if (i == idx * 2) {
                idx *= 2;
            }
            ans[i] = ans[i - idx] + 1;
        }
        return ans;
    }
}