/**
 * 13. Roman to Integer
 * Convert roman literal to number from left to right
 * Compensate when subtractive notation occurs
 * O(n) 
 */
public class Solution {
    private Map<Character,Integer> map = new HashMap<Character,Integer>(){
      {
          put('I', 1);
          put('V', 5);
          put('X', 10);
          put('L', 50);
          put('C', 100);
          put('D', 500);
          put('M', 1000);
      }  
    };
    public int romanToInt(String s) {
        int ans = 0, prev = 0, curr;
        for (char c : s.toCharArray()) {
            curr = map.get(c);
            ans += (curr > prev) ? (curr - 2 * prev) : curr;
            prev = curr;
        }
        return ans;
    }
}