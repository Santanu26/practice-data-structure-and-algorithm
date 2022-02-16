package priority_queue;

import java.util.PriorityQueue;

public class MaxValueOfEquation1499 {
    public static void main(String[] args) {
        int[][] points = {
                {1, 3}, {2, 0}, {5, 10}, {6, -10}};
        int[][] pp = {{-19,9},{-15,-19},{-5,-8}};
        int kk = 10;
        int k = 1;
        System.out.println(method(points, k));
        System.out.println(method(pp, kk));
    }

    public static int method(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int res = Integer.MIN_VALUE;




        for (int[] p : points) {
            int xi = p[0];
            while (!pq.isEmpty() && xi - pq.peek()[1] > k) {
                pq.poll();
            }
            int yi = p[1];
            if (!pq.isEmpty()) {
                int[] e = pq.peek();
                res = Math.max(res, xi + yi + e[0]);
            }
            pq.offer(new int[]{yi - xi, xi});
        }
        return res;
    }
}
