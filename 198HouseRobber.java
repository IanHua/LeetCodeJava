public class Solution {
    public int rob(int[] num) {
        int exclude = 0;
        int include = 0;
        for (int n : num) {
            int temp = exclude;
            exclude = Math.max(exclude, include);
            include = n + temp;
        }
        return Math.max(exclude, include);
    }
}