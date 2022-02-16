package stack;

import java.util.Stack;

public class Stack32 {
    public static void main(String[] args) {

        //System.out.println(method("(()"));
        //System.out.println(method(")()())"));
        //System.out.println(method("()(()"));
        System.out.println(longestValidParentheses("(()"));

    }

    public static int longestValidParentheses(String s) {

        int max = 0;
        int open = 0, close = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                int len = open + close;
                max = Math.max(max, len);
            } else if (close > open) {
                open = close = 0;
            }
        }


        open = 0;
        close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                int len = open + close;
                max = Math.max(max, len);

            } else if (open > close) {
                open = close = 0;
            }
        }

        return max;
    }
}
