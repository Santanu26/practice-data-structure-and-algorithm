package prefix_sum;

import java.util.ArrayList;
import java.util.List;

public class prefixSum2155 {
    public static void main(String[] args) {

        int[] nums = new int[]{0, 0, 1, 0};

        System.out.println(maxScoreIndices(nums));

    }

    public static List<Integer> maxScoreIndices(int[] nums) {// 0 0 1 0

        int[] left = new int[nums.length + 1];
        int[] right = new int[nums.length + 1];

        left[0] = 0;

        int prefixSum = 0;
        // create a left array.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left[i + 1] = prefixSum + 1;
                prefixSum = left[i + 1];
            } else {
                left[i + 1] = prefixSum;
            }
        }
        prefixSum = 0;
        right[nums.length] = 0;
        //create right array
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                right[i] = prefixSum + 1;
                prefixSum = right[i];
            } else {
                right[i] = prefixSum;
            }
        }

        int max = 0;

        List<Integer> res = new ArrayList<>();

        int currMax = 0;

        for (int i = 0; i <= nums.length; i++) {
            currMax = left[i] + right[i];
            if (max == currMax) {
                res.add(i);
            } else if (max < currMax) {
                max = currMax;
                res.clear();
                res.add(i);
            }
        }
        return res;
    }
}
