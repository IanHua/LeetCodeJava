/*
 * 151. Reverse Words in a String
 * Two pointers(substring) to select words.
 * Notice leading and trailing spaces.
 * O(n)
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int end = s.length(), start;
        for (start = end - 1; start >= 0; start--) {
            if (s.charAt(start) == ' ') {
                end = start;
            }
            else if (start == 0 || s.charAt(start - 1) == ' ') {
                if (ans.length() != 0) {
                    ans.append(' ');
                }
                ans.append(s.substring(start, end));
            }
        }
        return ans.toString();
    }
}