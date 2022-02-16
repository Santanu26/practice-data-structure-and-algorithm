package dynamic_programming;

public class Fibo {
    public static void main(String[] args) {
        int k = 500; // 1 1 2 3 5 8 13

        long[] nums = new long[k + 2];
        nums[0] = 0;
        nums[1] = 1;
        int n = 50;
        System.out.println(fib(n));
        // System.out.println(fibonacci(100, new long[100+2]));
    }

    public static int fib(int n) {

        if (n < 2) {
            return n;
        }
        int f = 0, s = 1;
        int sum = 0;
        while (n > 1) {
            sum = f + s;
            f = s;
            s = sum;
            n = n - 1;
        }
        return sum;
    }

}
