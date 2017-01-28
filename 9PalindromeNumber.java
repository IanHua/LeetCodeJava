/*
 * 9. Palindrome Number
 * Reverse integer to check if they are equal
 * Notice negative and overflow
 * x is not overflow && x == rev => rev is not overflow
 * If rev overflows, just return false
 * O(n)
 */
public class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int maxDiv10 = Integer.MAX_VALUE / 10;
        int digit;
        if (x < 0) return false;
        int rev = 0;
        while (x != 0) {
            if (rev > maxDiv10) return false;
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        if (original == rev) return true;
        else return false;
    }
}