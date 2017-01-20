/*
 * 28. Implement strStr()
 * Traverse haystack and see if it matches needle.
 * Notice empty string.
 * O(nm)
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int i, j;
        for (i = 0; ; i++) {
            for (j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
            }
        }
    }
}