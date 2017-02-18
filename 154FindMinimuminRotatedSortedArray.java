/**
 * 154. Find Minimum in Rotated Sorted Array II
 * Notice nums[base] == nums[mid] == nums[top]
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
            else if (nums[mid] < nums[base]){
                top = mid;
            }
            else {
                base += 1;
            }
        }
        return nums[base];
    }
}