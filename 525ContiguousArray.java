/**
 * 525. Contiguous Array
 * Switch variable: 1 and 0 can be considered as 1 and -1
 * count becomes 0 means equal numbers of 1 and 0
 * O(n)
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        // count -> index
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}