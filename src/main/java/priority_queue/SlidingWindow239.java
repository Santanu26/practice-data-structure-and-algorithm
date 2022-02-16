package priority_queue;

import java.util.*;

public class SlidingWindow239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] nums1 = new int[] {1,3,1,2,0,5};



        System.out.println(Arrays.toString(method(nums, k)));
        System.out.println(Arrays.toString(method1(nums1, k)));
        System.out.println(Arrays.toString(method1(new int[] {1,-1}, 1)));

    }

    public static int[] method1(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();

        int counter = 0;
        int[] res = new int[nums.length -k +1];
        for (int i  = 0; i< nums.length;i++) {

            int range = i - k + 1;

            while (!dq.isEmpty() && dq.peekFirst() < range ) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);

            if (i>= k-1) {
                res[counter] = nums[dq.peekFirst()];
                counter++;
            }
        }
        return res;
    }

    public static int[] method(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int[] res = new int[nums.length - k + 1];

        int index = 0;
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        res[index++] = maxHeap.peek();

        for (int i = k; i < nums.length; i++) {
            maxHeap.remove(nums[i - k]);
            maxHeap.add(nums[i]);
            res[index++] = maxHeap.peek();
        }
        return res;
    }
}
