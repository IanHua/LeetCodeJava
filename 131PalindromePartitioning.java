class Solution {
    private boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;
        int len = str.length();
        int start = 0, end = len - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
    
    private void backtrack(List<List<String>> ans, List<String> partitions, String str, int lastpos, int curpos) {
        if (curpos == str.length()) {
            ans.add(new ArrayList<>(partitions));
            return;
        }
        // cut
        String cut = str.substring(lastpos, curpos + 1);
        if (isPalindrome(cut)) {
            partitions.add(cut);
            backtrack(ans, partitions, str, curpos + 1, curpos + 1);
            partitions.remove(partitions.size() - 1);
        } 
        // no cut
        if (curpos < str.length() - 1) {
            backtrack(ans, partitions, str, lastpos, curpos + 1);
        }
        return;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.isEmpty()) return ans;
        backtrack(ans, new ArrayList<String>(), s, 0, 0);
        return ans;
    }
}