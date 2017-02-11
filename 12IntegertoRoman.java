/**
 * 12. Integer to Roman
 * I - 1; V - 5; X - 10; L - 50; C - 100; D - 500; M - 1000
 * Use tables to look up value and its roman literal
 * Minus from big value to small value
 * O(n)
 */
public class Solution {
    private static final int[] values = {
        1000, 900, 500, 400,
        100,  90,  50,  40,
        10,   9,   5,   4,
        1
    };
    private static final String[] symbols = {
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV",
        "I"
    };
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j, time;
        while (num > 0) {
            time = num / values[i];
            for (j = 0; j < time; j++) {
                sb.append(symbols[i]);
                num -= values[i];
            }
            i++;
        }
        return sb.toString();
    }
}