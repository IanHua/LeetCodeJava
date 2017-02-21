/**
 * 26. Remove Duplicates from Sorted Array
 * One pointer for update non-duplicated number, the other for traversal
 * O(n)
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int i = 0, j;
        for (j = 1; j < len; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}