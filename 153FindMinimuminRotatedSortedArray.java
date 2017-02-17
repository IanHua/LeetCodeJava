/**
 * 153. Find Minimum in Rotated Sorted Array
 * Binary Search
 * Compare the middle element with two end
 * O(logn)
 */
public class Solution {
    public int findMin(int[] nums) {
        int base = 0, top = nums.length - 1, mid;
        while (base < top && nums[base] >= nums[top]) {
            mid = (base + top) / 2;
            if (nums[mid] > nums[top]) {
                base = mid + 1;
            }
            else {
                top = mid;
            }
        }
        return nums[base];
    }
}