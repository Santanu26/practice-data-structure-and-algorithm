package basic;

import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(prefix_sum(nums)));
    }
    public static int[] prefix_sum(int[] nums) {
        for (int i = 1;i< nums.length;i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
