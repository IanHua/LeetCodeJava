/**
 * 20. Valid Parentheses
 * Use HashMap to avoid three if-elses
 * O(n)
 */
public class Solution {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            }
            else if (stack.isEmpty() || !map.get(stack.pop()).equals(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}