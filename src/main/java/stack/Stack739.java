package stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Stack739 {
    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(method(temp)));

    }
    public static int[] method(int[] temp) {
        Stack<Integer> stack = new Stack<>();

        for (int idx = 0;idx < temp.length;idx++) {
            while (!stack.empty() && temp[idx] > temp[stack.peek()]) {
                temp[stack.peek()] = idx - stack.peek();
                stack.pop();
            }
            stack.push(idx);
        }
        while (!stack.empty()) {
            temp[stack.peek()] = 0;
            stack.pop();
        }
        return temp;
    }
}
