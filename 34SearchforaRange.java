class Solution {
    private int findIndex(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        int len = nums.length;
        if (nums == null || len == 0) return res;
        if (target < nums[0] || target > nums[len-1]) return res;
        int left = findIndex(nums, target, true);
        if (left == len || nums[left] != target) return res;
        int right = findIndex(nums, target, false) - 1;
        res[0] = left;
        res[1] = right;
        return res;
    }
}