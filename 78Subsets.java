class Solution {
    /* Backtracking
    private void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> cur, int start) {
        if (cur.size() <= nums.length) ans.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(ans, nums, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        backtrack(ans, nums, cur, 0);
        return ans;
    }
    */
    // Bit manipulation
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int total = (int)Math.pow(2, nums.length);
        for (int i = 0; i < total; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < total; j++) {
                if (((j >> i) & 1) == 1) {
                    ans.get(j).add(nums[i]);
                }
            }
        }
        return ans;
    }
}