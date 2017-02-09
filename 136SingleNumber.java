/**
 * 136. Single Number
 * Use set to keep the number which only emerges once
 * O(n)
 */
public class Solution {
    public int singleNumber(int[] nums) throws IllegalArgumentException {
        if (nums == null) return -1;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                set.remove(x);
            }
            else {
                set.add(x);
            }
        }
        return set.iterator().next();
    }
}