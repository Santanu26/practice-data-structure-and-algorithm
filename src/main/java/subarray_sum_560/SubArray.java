package subarray_sum_560;

import java.util.HashMap;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{9, -9, 2, 3, 4};
        int k = 9;
        System.out.println(subArraySum(arr, k));
        System.out.println(subArraySum1(arr, k));
    }

    public static int subArraySum(int[] arr, int k) {
        int ans = 0;

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; ++end) {
                int sum = 0;

                for (int idx = start; idx <= end; idx++) {
                    sum += arr[idx];
                }
                if (sum == k) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public static int subArraySum1(int[] arr, int k) {
        HashMap<Integer, Integer> prefix_table = new HashMap<>();
        prefix_table.put(0, 1);
        int res = 0, prefix_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix_sum += arr[i];
            if (prefix_table.containsKey(prefix_sum - k)) {
                res += prefix_table.get(prefix_sum - k);
            }
            prefix_table.put(prefix_sum, prefix_table.getOrDefault(prefix_sum, 0) + 1);
            // ++prefix_table[prefix_sum];
        }
        return res;
    }
}
