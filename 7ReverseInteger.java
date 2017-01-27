/*
 * 7. Reverse Integer
 * Negative number can also be mod and divide
 * Use Integer.MAX_VALUE / 10 to check overflow
 * O(n)
 */
public class Solution {
    private final int maxDiv10 = Integer.MAX_VALUE / 10;
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (Math.abs(ans) > maxDiv10) {
                return 0;
            }
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }
}