/*
 * 66. Plus One
 * ArrayList <-> int[] can only be done by for loop
 * Notice overflow
 * O(n)
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length, i;
        for (i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            }
            else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] newDigits = new int[len+1];
        newDigits[0] = 1;
        for (i = 1; i <= len; i++) {
            newDigits[i] = 0;
        }
        return newDigits;
    }
}