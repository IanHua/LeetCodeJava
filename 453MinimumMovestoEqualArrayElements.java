/*
 * 453. Minimum Moves to Equal Array Elements
 * Increment all elements except one is equivalent to decrement this one 
 * element. So find the min value and sum the diff.
 * O(n)
 */
public class Solution {
    public int minMoves(int[] nums) {
        int moves = 0, i;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        for (i = 0; i < len; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        for (i = 0; i < len; i++) {
            moves += nums[i] - min;
        }
        return moves;
        
    }
}