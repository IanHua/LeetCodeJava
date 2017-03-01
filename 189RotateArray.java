/**
 * 189. Rotate Array
 * (i + k) % len is good for rotate
 * O(n)
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] tmpArray = new int[len];
        int i;
        for (i = 0; i < len; i++) {
            tmpArray[(i + k) % len] = nums[i];
        }
        for (i = 0; i < len; i++) {
            nums[i] = tmpArray[i];
        }
    }
}