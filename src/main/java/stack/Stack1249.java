package stack;

import java.util.Stack;

public class Stack1249 {
    public static void main(String[] args) {
        System.out.println(method("lee(t(c)o)de)"));

    }

    public static String method(String s) {
        Stack<Integer> stack = new Stack<>();

        StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.size() > 0 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        while (stack.size() > 0) {
            stringBuilder.deleteCharAt(stack.pop());
        }

        return stringBuilder.toString();

    }
}
