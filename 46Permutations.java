class Solution {
    private void track(List<List<Integer>> ans, int len, List<Integer> curPermute, LinkedList<Integer> remain) {
        if (curPermute.size() == len || remain.isEmpty()) {
            List<Integer> copy = new ArrayList<>(curPermute);
            ans.add(copy);
            return;
        }
        for (int i = 0; i < remain.size(); i++) {
            curPermute.add(remain.get(i));
            int target = remain.remove(i);
            track(ans, len, curPermute, remain);
            curPermute.remove(curPermute.size()-1);
            remain.add(i, target);
        }
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        List<Integer> curPermute = new ArrayList<>();
        LinkedList<Integer> remain = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            remain.add(nums[i]);
        }
        track(ans, len, curPermute, remain);
        return ans;
    }
}