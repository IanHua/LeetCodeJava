/**
 * 557. Reverse words in a string III
 * Split the string with the delimiter of space and reverse each word
 * O(n)
 */
public class Solution {
    private String reverse(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int mid = len / 2;
        for (int i = 0; i < mid; i++) {
            char tmp = chs[i];
            chs[i] = chs[len - 1 - i];
            chs[len - 1 - i] = tmp;
        }
        return new String(chs);
    }
    public String reverseWords(String s) {
        if (s.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        String prefix = "";
        for (String word : words) {
            sb.append(prefix);
            prefix = " ";
            sb.append(reverse(word));
        }
        
        return sb.toString();
    }
}