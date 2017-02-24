/**
 * 303. Range Sum Query - Immutable
 * Cache the sum from index 0 to index i in sum[i+1]
 * O(n)
 */
public class NumArray {
    
    private int[] sum;
    public NumArray(int[] nums) {
        int len = nums.length;
        sum = new int[len+1];
        for (int i = 0; i < len; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}