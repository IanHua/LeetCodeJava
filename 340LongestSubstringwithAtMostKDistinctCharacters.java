class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.isEmpty() || k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int maxLen = 0;
        while (end != s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if (map.size() <= k) {
                if (end - start + 1 > maxLen) maxLen = end - start + 1;
                end++;   
            } else {
                char r = s.charAt(start);
                map.put(r, map.get(r) - 1);
                if (map.get(r) == 0) map.remove(r);
                start++;
                end++;
            }
        }
        return maxLen;
    }
}