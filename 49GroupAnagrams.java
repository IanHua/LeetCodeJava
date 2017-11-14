class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) return ans;
        // String -> index
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String origin = new String(chars);
            if (!map.containsKey(origin)) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                ans.add(anagrams);
                map.put(origin, ans.size() - 1);
            } else {
                List<String> anagrams = ans.get(map.get(origin));
                anagrams.add(str);
            }
        }
        return ans;
    }
}