package deque_implementation;

import java.util.*;

public class Sliding239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(max(nums, k));
    }

    public static int[] max(int[] nums, int k) {
        List<Integer> output = new ArrayList<>();

        ArrayDeque<Integer> arrayIndex = new ArrayDeque<>(k);

        for (int index = 0; index < nums.length; index++) { //{1, 3, -1, -3, 5, 3, 6, 7};
            while (!arrayIndex.isEmpty()
                    && nums[arrayIndex.getLast()] <= nums[index]) {
                arrayIndex.removeLast();
            }
            arrayIndex.addLast(index);
            if (arrayIndex.getFirst() == index - k) {
                arrayIndex.removeFirst();
            }
            if (index + 1 >= k) {
                output.add(nums[arrayIndex.getFirst()]);
            }
        }
        return output.stream().mapToInt(i -> i).toArray();
    }
}
