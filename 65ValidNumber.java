/*
 * 65. Valid Number
 * Traverse the string, devide and conquer.
 * O(n)
 */
public class Solution {
    public boolean isNumber(String s) {
        int i = 0, len = s.length();
        boolean isNumeric = false;
        // Leading spaces
        while (i < len && s.charAt(i) == ' ') i++;
        // +/-
        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        // First part of number
        while (i < len && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        // Second part of number if it is a float point
        if (i < len && s.charAt(i) == '.') {
            i++;
            while (i < len && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        // Second part of number if it has exponent
        if (isNumeric && i < len && s.charAt(i) == 'e') {
            i++;
            isNumeric = false;
            // Notice +/- after e
            if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < len && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        // Trailing spaces
        while (i < len && s.charAt(i) == ' ') i++;
        return isNumeric && i == len;
    }
}