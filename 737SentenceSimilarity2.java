class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, String> m = new HashMap<>();
        for (String[] p : pairs) {
            String parent1 = find(m, p[0]), parent2 = find(m, p[1]);
            if (!parent1.equals(parent2)) m.put(parent1, parent2);
        }

        for (int i = 0; i < words1.length; i++)
            if (!words1[i].equals(words2[i]) && !find(m, words1[i]).equals(find(m, words2[i]))) return false;

        return true;
    }
    private String find(Map<String, String> m, String s) {
        if (!m.containsKey(s)) m.put(s, s);
        if (s.equals(m.get(s))) return s;
        m.put(s, find(m, m.get(s)));
        return m.get(s);
    }
}