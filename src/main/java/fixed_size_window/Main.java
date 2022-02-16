package fixed_size_window;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 4, 5, 3, 8, 2};
        int k = 5;

        System.out.println(slidingWindow(nums, k));
    }

    private static int slidingWindow(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int best = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            best = Math.max(best, sum);
        }
        return best;

    }
}
