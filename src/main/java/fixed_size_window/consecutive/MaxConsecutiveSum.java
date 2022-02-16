package fixed_size_window.consecutive;

public class MaxConsecutiveSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 4, 5, 3, 8, 2};
        int k = 5;
        System.out.println(bruteForce(nums, k));
        System.out.println(sophisticated(nums, k));
        // System.out.println(maxConsecutiveSumTest(nums, k));

    }

    public static int bruteForce(int[] nums, int k) {

        int best = Integer.MIN_VALUE;

        for (int start = 0; start < nums.length - k + 1; start++) {
            int sum = 0;

            for (int s = 0; s < k; s++) {
                sum += nums[s + start];
            }
            best = Math.max(best, sum);
        }
        return best;
    }

    public static int sophisticated(int[] nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int best = windowSum;

        for (int end = k; end < nums.length; end++) {
            windowSum += nums[end] - nums[end - k];
            best = Math.max(windowSum, best);
        }
        return best;
    }

   /* public static int maxConsecutiveSumTest(int[] nums, int k) {

        prefixSum(nums);

        int best = Integer.MIN_VALUE;
        for (int start = 0; start < nums.length - k + 1; ++start) {
            best = Math.max(best, rangeSum(start, start + k - 1, nums));
        }
        return best;
    }*/

    public static int rangeSum(int start, int end, int[] prefixSum) {
        if (start == 0) {
            return prefixSum[end];
        }
        return prefixSum[end] - prefixSum[start];
    }

    public static void prefixSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }
}
