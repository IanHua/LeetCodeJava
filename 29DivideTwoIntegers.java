class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        int sign;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) sign = 1;
        else sign = -1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int res = 0;
        while (dvd >= dvs) {
            long tmp = dvs, multiple = 1;
            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                multiple <<= 1;
            }
            dvd -= tmp;
            res += multiple;
        }
        return sign == 1 ? res : -1 * res;
        
    }
}