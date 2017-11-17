import java.io.*;
import java.util.*;

/*
 
You are building an educational website and want to create a simple calculator for students to use. For now, the calculator will only allow addition and subtraction of positive integers.

We also want to allow parentheses in our input. Given an expression string using the "+", "-", "(", and ")" operators like "5+(16-2)", write a function to parse the string and evaluate the result.

Sample input:
    expression1 = "5+16-((9-6)-(4-2))"
    expression2 = "22+(2-4)"
 
Sample output:
    evaluate(expression1) => 20
    evaluate(expression2) => 20


 
 */

class Solution {
  public static int calculator(String str) {
    if (str == null || str.isEmpty()) return -1;
    Stack<Character> operator = new Stack<>();
    Stack<Integer> number = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      // operator
      if (!Character.isDigit(ch)) {
        if (ch == '+' || ch == '-' || ch == '(') operator.push(ch);
        else if (ch == ')') {
          int right = number.pop();
          int left = number.pop();
          char tmpop = operator.pop();
          operator.pop();
          if (tmpop == '+') number.push(left + right);
          else if (tmpop == '-') number.push(left - right);
        }
      } else {
        // number
        int start = i;
        int end = start;
        while (end < str.length() && Character.isDigit(str.charAt(end))) end++;
        String tmpnum = str.substring(start, end);
        int intNum = Integer.parseInt(tmpnum);
        number.push(intNum);
        i = end - 1;
      }
    }
    while (!operator.isEmpty()) {
      int right = number.pop();
      int left = number.pop();
      char tmpop = operator.pop();
      if (tmpop == '+') number.push(left + right);
      else if (tmpop == '-') number.push(left - right);
    }
    return number.peek();
  }
  /*public static int calculator(String str) {
    if (str == null || str.isEmpty()) return -1;
    int res = 0;
    String tmpstr = "+" + str;
    for (int i = 0; i < tmpstr.length(); i++) {
      char operator = tmpstr.charAt(i);
      i++;
      int start = i;
      int end = start;
      if (operator == '+') {
        while (end < tmpstr.length() && Character.isDigit(tmpstr.charAt(end))) end++;
        String num = tmpstr.substring(start, end);
        int rightNum = Integer.parseInt(num);
        res += rightNum;
      } else if (operator == '-') {
        while (end < tmpstr.length() && Character.isDigit(tmpstr.charAt(end))) end++;
        String num = tmpstr.substring(start, end);
        int rightNum = Integer.parseInt(num);
        res -= rightNum;
      }
      if (end == tmpstr.length() - 1) break;
      else i = end - 1;
    }
    return res;
  }*/
  public static void main(String[] args) {
    String expression1 = "5+16-((9-6)-(4-2))";
    String expression2 = "22+(2-4)";
    System.out.println(calculator(expression1));
    System.out.println(calculator(expression2));
    System.out.println("I hope this still works :)");
  }
}
