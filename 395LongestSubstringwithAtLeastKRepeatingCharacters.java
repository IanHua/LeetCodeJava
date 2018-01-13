class Solution {
    private int helper(char[] chs, int start, int end, int k) {
        if (end - start < k) return 0;
        int len = chs.length;
        int[] cnt = new int[26];
        for (int i = start; i < end; i++) {
            cnt[chs[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                for (int j = start; j < end; j++) {
                    if (chs[j] - 'a' == i) {
                        int left = helper(chs, start, j, k);
                        int right = helper(chs, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || k < 0) return 0;
        char[] chs = s.toCharArray();
        return helper(chs, 0, len, k);
    }
}