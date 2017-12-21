class Solution {
    private String getRange(int lower, int upper) {
        return lower == upper ? String.valueOf(lower) : String.format("%d->%d", lower, upper);
    }
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(getRange(lower, upper));
            return res;
        }
        int len = nums.length;
        int next = lower;
        for (int i = 0; i < len; i++) {
            if (nums[i] < next) continue;
            else if (nums[i] == next) {
                next++;
                continue;
            } else {
                res.add(getRange(next, nums[i] - 1));
                next = nums[i] + 1;
                if (nums[i] == Integer.MAX_VALUE) break;
            }
        }
        if (nums[len-1] < Integer.MAX_VALUE && next <= upper) res.add(getRange(next, upper));
        return res;
    }
}