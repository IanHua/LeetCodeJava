/**
 * 150. Evaluate Reverse Polish Notation
 * Use stack to solve Reverse Polish Notation (RPN)
 * Stack stores numbers and pops out two numbers when encounters a operator
 * O(n)
 */
public class Solution {
    private final Set<String> operator = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));
    private int eval(int x, int y, String token) {
        switch (token) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            default: return x / y;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (operator.contains(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(eval(x, y, token));
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}