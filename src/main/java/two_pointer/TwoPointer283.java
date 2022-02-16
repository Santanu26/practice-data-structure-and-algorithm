package two_pointer;

import java.util.Arrays;

public class TwoPointer283 {
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};

        System.out.println(Arrays.toString(method(nums)));

    }
    public static int[] method(int[] nums) {

        int nonZeroIdx = 0;
        for (int idx = 0;idx< nums.length;idx++) {
            if (nums[idx]!=0) {
                swap(idx, nonZeroIdx, nums);
                nonZeroIdx++;
            }
        }
        return nums;
    }
    public static void swap(int first, int second, int[] nums) {
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }
}
