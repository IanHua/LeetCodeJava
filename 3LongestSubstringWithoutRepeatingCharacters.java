/*
 * 3. Longest Substring Without Repeating Characters
 * Use HashMap to save each character and its index mapping
 * One time traverse by sliding window
 * O(n)
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, len = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                // New head must greater than or equal to current head
                i = Math.max(map.get(s.charAt(j)), i);
            }
            map.put(s.charAt(j), j + 1);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}