class Solution {
    private void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == 2 * max) {
            list.add(str);
            return;
        }
        if (open < max) backtrack(list, str + "(", open + 1, close, max);
        if (open > close) backtrack(list, str + ")", open, close + 1, max);
        return;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) return ans;
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
}