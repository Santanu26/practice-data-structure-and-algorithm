package priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Basic {
    public static void main(String[] args) {
        int[] nums = new int[] {709, 889, 50, 0 ,100, 100};
        method(nums);

    }
    public static void method(int[] nums) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());


        for (int num: nums) {
            minHeap.offer(num);
            maxHeap.offer(num);
        }

        for (int i = 0;i< nums.length;i++) {
            System.out.println("Min: "+minHeap.poll() + "Max: " + maxHeap.poll());
        }

    }

}
