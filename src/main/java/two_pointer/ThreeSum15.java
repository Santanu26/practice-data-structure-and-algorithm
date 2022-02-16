package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, -1, -1,-1, -4, 2};
        System.out.println(method(nums));
    }

    public static List<List<Integer>> method(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int len = nums.length;

        if (len < 3 || nums[0] > 0 || nums[len - 1] < 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = len - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {

                int sum = nums[left] + nums[right] + nums[i];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
                left++;
                right--;
            }
        }
        return res;
    }

}
