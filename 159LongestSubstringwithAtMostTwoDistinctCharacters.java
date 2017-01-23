/*
 * 159. Longest Substring with At Most Two Distinct Characters
 * Sliding window to scan substring
 * Maintain numDistinct and count array to keep only two distinct characters
 * Also compatible for k distinct characters
 * O(n)
 */
public int lengthOfLongestSubstringTwoDistinct(String s) {
   int i = 0, j = 0, len = s.length();
   int ans = 0, numDistinct = 0;
   int[] count = new int[256];
   for (; j < len; j++) {
      if (count[s.charAt(j)] == 0) numDistinct++;
      count[s.charAt(j)]++;
      while (numDistinct > 2) {
         count[s.charAt(i)]--;
         if (count[s.charAt(i)] == 0) numDistinct--;
         i++;
      }
      ans = Math.max(ans, j - i + 1);
   }
   return ans;
}