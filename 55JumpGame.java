class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int reach = 0;
        for (int i = 0; i < n; i++) {
            if (i > reach) return false;
            reach = Math.max(nums[i] + i, reach);
        } 
        return true;
    }
}