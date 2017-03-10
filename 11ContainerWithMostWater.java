/** 
 * 11. Container With Most Water
 * Greedy: Use two pointers to maintain max area
 * Move shorter index because there may be a larger container if there is 
 * a higher line
 * O(n)
 */
public class Solution {
    private int area(int i, int j, int h1, int h2) {
        return (j - i) * Math.min(h1, h2);
    }
    public int maxArea(int[] height) {
        int len = height.length;
        int leftMax = 0, rightMax = 0;
        int l = 0, r = len - 1;
        int ans = 0;
        int tmpArea = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] > leftMax) {
                    leftMax = height[l];
                    tmpArea = area(l, r, height[l], height[r]);
                    if (tmpArea > ans) ans = tmpArea;
                }
                l++;
            }
            else {
                if (height[r] > rightMax) {
                    rightMax = height[r];
                    tmpArea = area(l, r, height[l], height[r]);
                    if (tmpArea > ans) ans = tmpArea;
                }
                r--;
            }
        }
        return ans;
    }
}