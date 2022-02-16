package subarray_sum_560;

import java.util.HashMap;

public class SubArraySumPractice {
    public static void main(String[] args) {
        int[] arr = new int[]{9, -9, 2, 3, 4};
        int k = 9;
       // System.out.println(subArraySum(arr, k));
        //System.out.println(subArraySum(arr, k));

        System.out.println(subArraySumHashMap(arr, k));
        System.out.println(subArraySumHashMap(arr, k));
    }

    public static int subArraySumHashMap(int[] nums, int k) {

        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (hashMap.containsKey(sum - k)) {
                res += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    public static int subArraySum(int[] nums, int k) {
        int res = 0;
        prefixSum(nums);
        for (int start = 0; start < nums.length; ++start) {
            for (int end = start; end < nums.length; ++end) {
                if (rangeSum(start, end, nums) == k) {
                    res++;
                }
            }
        }
        return res;
    }

    private static int rangeSum(int start, int end, int[] nums) {
        if (start == 0) {
            return nums[end];
        }
        return nums[end] - nums[start];
    }

    private static void prefixSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }
}
