class Solution {
    public int helper(int[] num, int low, int high) {
        int exclude = 0;
        int include = 0;
        for (int i = low; i <= high; i++) {
            int temp = exclude;
            exclude = Math.max(exclude, include);
            include = num[i] + temp;
        }
        return Math.max(exclude, include);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        else if (n == 1) return nums[0];
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
}