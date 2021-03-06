class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n == 0) return false;
        int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= c1) c1 = num;
            else if (num <= c2) c2 = num;
            else return true;
        }
        return false;
    }
}