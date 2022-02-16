package fixed_size_window;

import java.util.HashMap;
import java.util.Map;

public class HashMap219 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums2 = new int[]{1, 2, 3, 1, 2, 3};
        int k = 3;

        System.out.println( duplicate(nums, k));
        System.out.println( duplicate(nums2, 2));
    }

    private static boolean duplicate(int[] nums, int k) {

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i]) && i - m.get(nums[i]) <= k) {
                return true;
            }
            m.put( nums[i],i);
        }
        return false;
    }
}
