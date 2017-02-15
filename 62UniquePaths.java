/**
 * 62. Unique Paths
 * Combination: C(m+n-2,m-1)
 * Notice overflow, use long to store result
 * O(m)
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        long ans = 1;
        int i, tmp;
        if (m < n) {
            tmp = m;
            m = n;
            n = tmp;
        }
        for (i = 1; i <= m - 1; i++) {
            ans *= n - 1 + i;
            ans /= i;
        }
        return (int)ans;
    }
}