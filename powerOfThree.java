/*
 * Power Of Three
 * Guard check for illegal number n. Use epsilon to handle double
 * precision error.
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        final double epsilon = 1e-10;
        return (Math.log10(n) / Math.log10(3)) % 1 <= 2 * epsilon;
    }
}