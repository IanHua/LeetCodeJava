public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res = res * 2 + 1;
            } else {
                res *= 2;
            }
            n >>>= 1;
        }
        return res;
    }
}