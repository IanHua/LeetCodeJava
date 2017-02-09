/**
 * 260. Single Number III
 * HashMap to maintain emerge times
 * O(n)
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans =  new int[2];
        int count, pos = 0;
        for (int x : nums) {
            count = map.containsKey(x) ? map.get(x) : 0;
            map.put(x, count + 1);
        }
        for (int x : nums) {
            if (map.get(x) == 1) {
                ans[pos++] = x;
            }
        }
        return ans;
    }
}