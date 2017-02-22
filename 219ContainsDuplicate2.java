/** 
 * 219. Contains Duplicate II
 * HashMap: value -> index
 * O(n)
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        int i;
        for (i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) return true;
                else {
                    map.put(nums[i], i);
                }
            }
            else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}