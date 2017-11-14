class Solution {
    public String reverseString(String s) {
        if (s == null || s.isEmpty()) return "";
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char left = chars[i];
            chars[i] = chars[len-i-1];
            chars[len-i-1] = left;
        }
        return new String(chars);
    }
}