package fixed_size_window;

import java.util.Arrays;

public class SlidingWindow239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(slidingWindow(nums, k)));

    }

    public static int[] slidingWindow(int[] nums, int k) {

        int range = nums.length - k + 1;
        int[] res = new int[range];

        for (int i = 0; i < range; i++) {
            int tmpMax = nums[i];

            for (int start = i + 1; start <= i + k - 1; start++) {
                tmpMax = Math.max(tmpMax, nums[start]);
            }
            res[i] = tmpMax;
        }
        return res;
    }
}
