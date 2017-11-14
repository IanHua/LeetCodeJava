class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        int red = 0, blue = len - 1;
        for (int i = 0; i < len; i++) {
            while (nums[i] == 2 && i < blue) {
                int tmp = nums[blue];
                nums[blue] = nums[i];
                nums[i] = tmp;
                blue--;
            }
            while (nums[i] == 0 && i > red) {
                int tmp = nums[i];
                nums[i] = nums[red];
                nums[red] = tmp;
                red++;
            }
        }
        return;
    }
}