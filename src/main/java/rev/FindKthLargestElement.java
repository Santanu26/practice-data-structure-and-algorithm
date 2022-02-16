package rev;

import java.util.PriorityQueue;

public class FindKthLargestElement {
    public static void main(String[] args) {
        int[] nums = new int[] {30,1,60,4,10,0};
        int k = 3;

        System.out.println(findKthLargestElementFromArr(nums, k));

    }
    public static int findKthLargestElementFromArr(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: nums) {
            pq.add(num);

            if (pq.size()>k) {
                pq.poll();
            }
        }
        return pq.poll();

    }
}
