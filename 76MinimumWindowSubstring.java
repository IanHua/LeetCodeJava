class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> chCnt = new HashMap<>();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, minStart = 0, counter = t.length();
        for (char c : t.toCharArray()) {
            if (!chCnt.containsKey(c)) {
                chCnt.put(c, 1);
            } else {
                chCnt.put(c, chCnt.get(c) + 1);
            }
        }
        while (end < s.length()) {
            char c = s.charAt(end);
            if (chCnt.containsKey(c)) {
                // find valid
                if (chCnt.get(c) > 0) counter--;
                chCnt.put(c, chCnt.get(c) - 1);
            }
            end++;
            // valid
            while (counter == 0) {
                c = s.charAt(start);
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                if (chCnt.containsKey(c)) {
                    // becomes invalid
                    if (chCnt.get(c) == 0) counter++;
                    chCnt.put(c, chCnt.get(c) + 1);
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}