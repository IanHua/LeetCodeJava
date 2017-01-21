/*
 * 8. String to Integer (atoi)
 * Notice special conditions
 * empty return 0
 * not a number return 0
 * ignore leading spaces
 * ignore trailing characters
 * positive or negative
 * integer overflow
 * O(n)
 */
public class Solution {
    private final int maxDiv10 = Integer.MAX_VALUE / 10;
    public int myAtoi(String str) {
        int i = 0, len = str.length();
        int sign = 1;
        int num = 0;
        int digit;
        while (i < len && str.charAt(i) == ' ') i++;
        if (i < len && str.charAt(i) == '+') {
            i++; 
        }
        else if (i < len && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        while (i < len && Character.isDigit(str.charAt(i))) {
            digit = Character.getNumericValue(str.charAt(i));
            if (num > maxDiv10 || (num == maxDiv10 && digit >= 8)) {
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }
}