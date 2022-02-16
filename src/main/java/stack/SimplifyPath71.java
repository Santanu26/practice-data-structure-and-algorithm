package stack;


import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));

    }
    public static String simplifyPath(String path) {

        String[] tokens = path.split("/");
        Deque<String> stack = new LinkedList<>();

        for (String token: tokens) {
            if (token.equals("") || token.equals(".")) {
                continue;
            }
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(token);
            }
        }
        if (stack.size() ==0) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (String directory: stack ) {
            stringBuilder.append("/").append(directory);
        }
        return stringBuilder.toString();
    }
}
