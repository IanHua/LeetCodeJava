class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        // Find index of smallest number
        int rot = low;
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int realmid = (mid + rot) % n;
            if (nums[realmid] == target) return realmid;
            else if (nums[realmid] < target) low = mid + 1;
            else high = mid - 1;
            
        }
        return -1;
    }
}