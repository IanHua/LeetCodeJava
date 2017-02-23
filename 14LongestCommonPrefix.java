/**
 * 14. Longest Common Prefix
 * Vertical Scanning
 * O(n)
 */public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int i, j, len = strs[0].length();
        for (i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}