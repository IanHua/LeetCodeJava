/**
 * 35. Search Insert Position
 * Binary Search
 * while (base <= top) 
 * O(logn)
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int base = 0, top = nums.length - 1, mid;
        while (base <= top) {
            mid = (base + top) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                base = mid + 1;
            }
            else {
                top = mid - 1;
            }
        }
        return base;
    }
}