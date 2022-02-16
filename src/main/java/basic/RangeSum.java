package basic;

public class RangeSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println(range_sum(0,3, nums));
        prefix_sum(nums);

        System.out.println(method(0,3, nums));
    }
    public static void prefix_sum(int[] nums) {
        for (int i = 1;i<nums.length;i++) {
            nums[i] += nums[i-1];
        }
    }
    public static int range_sum(int start, int end, int[] nums) {
        int sum = 0;
        for (int i = start;i<=end;i++) {
            sum+= nums[i];
        }
        return sum;
    }
    public static int method(int start, int end, int[] nums) {
        if (start ==0) {
            return nums[end];
        }
        return nums[end]- nums[start-1];
    }
}
