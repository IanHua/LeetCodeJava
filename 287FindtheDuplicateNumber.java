class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        if (len > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (slow != fast) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
       
        return -1;
    }
}