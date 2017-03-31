/**
 * 507. Perfect Number
 * Store the divisor upto sqrt(num)
 * Notice the condition of i * i = num
 * O(sqrt(n))
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        int len = (int) Math.sqrt(num);
        int sum = 1;
        for (int i = 2; i <= len; i++) {
            if (num % i == 0) {
                set.add(i);
            }
        }
        for (Integer i : set) {
            sum += i;
            if (i * i != num) {
                sum += num / i;
            }
        }
        return (sum == num) ? true : false;
    }
}