class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.isEmpty()) return -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmpChar = s.charAt(i);
            tmpChar = Character.toUpperCase(tmpChar);
            int tmpInt = tmpChar - 'A' + 1;
            res = res * 26 + tmpInt;
        }
        return res;
    }
}