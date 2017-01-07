/*
 * 191. Number of 1 Bits
 * For each least significant bit, use AND to check if it is 1, 
 * and every time right shift n (SAR).
 * O(1)
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int i, ans = 0;
        for (i = 0;i < 32;i++){
            if ((n & 0x1) == 1){
                ans++;
            }
            n = n >> 1;
        }
        return ans;
    }
}