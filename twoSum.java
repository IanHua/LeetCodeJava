/*
 * Two Sum
 * Use HashMap to store the (value, index) pair of each element so that 
 * reduce the time of finding complement from O(n) to O(1). Because we
 * do the check before put, so it is not a problem for duplicate elements.
 */
public class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i, len, complement;
		len = nums.length;
		for (i = 0; i < len; i++) {
			complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			else {
				map.put(nums[i], i);
			}
		}
		return null;
	}
}