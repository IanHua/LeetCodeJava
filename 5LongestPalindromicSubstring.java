/*
 * 5. Longest Palindromic Substring
 * DP
 * P(i, j): True if s.substring(i,j+1) is palindrome
 * P(i, j) = P(i+1,j-1) && s.charAt(i) == s.charAt(j)
 * O(n^2)
 */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int i, j;
        int maxLen = 1, start = 0, end = 0;
        boolean[][] P = new boolean[len][len];
        for (i = 0; i < len - 1; i++) {
            P[i][i] = true;
            P[i][i+1] = (s.charAt(i) == s.charAt(i+1));
            if (P[i][i+1]) {
                maxLen = 2;
                start = i;
                end = i + 1;
            }
        }
        P[len-1][len-1] = true;
        for (j = 2; j < len; j++) {
            for (i = 0; i < len - 1; i++) {
                if (i + j < len) {
                    P[i][i+j] = P[i+1][i+j-1] && (s.charAt(i) == s.charAt(i+j));
                    if (P[i][i+j] && j + 1 > maxLen) {
                        maxLen = j + 1;
                        start = i;
                        end = i + j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}