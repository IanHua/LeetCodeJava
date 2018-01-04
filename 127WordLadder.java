class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        int len = wordList.size();
        int res = 1;
        HashSet<String> wordSet = new HashSet<>();
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) return 0;
        int wordLen = beginWord.length();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            HashSet<String> tmpSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < wordLen; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char old = chs[i];
                        chs[i] = ch;
                        String tmpword = String.valueOf(chs);
                        if (endSet.contains(tmpword)) return res + 1;
                        if (wordSet.contains(tmpword) && !visited.contains(tmpword)) {
                            tmpSet.add(tmpword);
                            visited.add(tmpword);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = tmpSet;
            res++;
        }
        return 0;
    }
}