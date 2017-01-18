/*
 * 167. Two Sum II - Input array is sorted
 * move from the min element and the max element so that the sum equals to the target
 * O(n)
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int sum;
        while (i < j) {
            sum = numbers[i] + numbers[j];
            if (sum > target) j--;
            else if (sum < target) i++;
            else if (sum == target) return new int[]{i+1, j+1};
        }
        return null;
    }
}