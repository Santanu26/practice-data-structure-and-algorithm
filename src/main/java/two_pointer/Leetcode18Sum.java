package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums1 = new int[]{2,2,2,2,2};
        int k = 0;
        System.out.println(method(nums, k));
        System.out.println(method(nums1, 8));
    }
    public static List<List<Integer>> method(int[] nums, int k) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int len = nums.length;

        /*if (len < 4 || nums[0] > k || nums[len - 1] < k) {
            return res;
        }*/

        for (int start = 0; start < len - 3; start++) {
            if (start != 0 && nums[start] == nums[start - 1]) {
                continue;
            }
            for (int i = start + 1; i < len - 2; i++) {

                if (i != start+1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = len - 1;

                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[start];
                    if (sum == k) {
                        res.add(Arrays.asList(nums[left], nums[right], nums[i], nums[start]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                    } else if (sum > k) {
                        right--;
                    } else {
                        left++;
                    }
                }

            }
        }

        return res;

    }
}
