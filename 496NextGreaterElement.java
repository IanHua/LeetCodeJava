/**
 * 496. Next Greater Element I
 * Store (value -> position) pairs in HashMap beforehand for 
 * looking up the position of each value in findNums
 * O(n*m)
 */
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int len = findNums.length;
        int n = nums.length;
        int[] ans = new int[len];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            int tmp = findNums[i];
            int pos = map.get(tmp);
            boolean find = false;
            for (int j = pos + 1; j < n; j++) {
                if (nums[j] > tmp) {
                    ans[i] = nums[j];
                    find = true;
                    break;
                }
            }
            if (!find) ans[i] = -1;
        }
        return ans;
    }
}