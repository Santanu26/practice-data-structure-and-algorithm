package priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Nice295 {

    static PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder()); // maxHeap
    static PriorityQueue<Integer> min = new PriorityQueue<>(); // minheap

    public static void main(String[] args) {

        addNum(1);
        addNum(2);
        System.out.println(findMedian());
        addNum(3);
        System.out.println(findMedian());

    }

    public static void addNum(int num) {

        max.offer(num);
        min.offer(max.poll());

        if (min.size() > max.size()) {
            max.offer(min.poll());
        }
    }

    public static double findMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        }
        return max.peek();

    }
}
