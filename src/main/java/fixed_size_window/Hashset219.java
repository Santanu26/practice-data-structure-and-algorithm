package fixed_size_window;

import java.util.HashSet;
import java.util.Set;

public class Hashset219 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums2 = new int[]{1, 2, 3, 1, 2, 3};
        int k = 2;

        System.out.println(containsDuplicate(nums, k));
        System.out.println(containsDuplicate(nums2, 2));
    }

    private static boolean containsDuplicate(int[] nums, int k) {

        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i])) {
                return true;
            }
            s.add(nums[i]);
            if (s.size() > k) {
                s.remove(nums[i - k]);
            }
        }
        return false;


    }
}
