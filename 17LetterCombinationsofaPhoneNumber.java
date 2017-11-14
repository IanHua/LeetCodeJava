class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if (digits == null || digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int k = 0; k < digits.length(); k++) {
            int c = Character.getNumericValue(digits.charAt(k));
            while (ans.get(0).length() == k) {
                String pre = ans.remove(0);
                for (char s : mapping[c].toCharArray()) {
                    ans.add(pre + s);
                }
            }
        }
        return ans;
    }
}