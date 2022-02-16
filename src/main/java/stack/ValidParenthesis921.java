package stack;

import java.util.Stack;

public class ValidParenthesis921 {
    public static void main(String[] args) {
        String s = "())";
        String s1 = "))";
        String s2 = "(((";
        System.out.println(method(s2));

    }
    public static int method(String s) {

        Stack<Character> stack = new Stack<>();

        for (int idx = 0;idx< s.length();idx++) {
            if (s.charAt(idx)=='(') {
                stack.push(s.charAt(idx));
            } else if (s.charAt(idx) == '(' && !stack.isEmpty() && stack.peek() == ')') {
                stack.pop();
            } else {
                stack.push(')');
            }
        }
        return stack.size();
    }
}
