class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int xor = x ^ y;
        for (int i = 0; i < 32; i++) {
            if (((xor >> i) & 1) == 1) res++;
        }
        return res;
    }
}