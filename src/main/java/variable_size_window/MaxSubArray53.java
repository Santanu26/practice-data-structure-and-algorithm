package variable_size_window;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSubArray53 {
    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(prefixSumApproach(nums));
        System.out.println(kadaneAlgo(nums));
        System.out.println(kadanesForMin(nums));

        int[] ints = IntStream.concat(Arrays.stream(nums), Arrays.stream(nums)).toArray();
        System.out.println(Arrays.toString(ints));

    }
    public static int kadanesForMin(int[] nums) {
        int currSum = 0;
        int minSub = nums[0];

        for (int i = 0;i< nums.length;i++) {
            if (currSum<0) {
                currSum = 0;
            }
            currSum+= nums[i];
            minSub = Math.min(minSub, currSum);
        }
        return minSub;
    }
    public static int prefixSumApproach(int[] nums) {

        int prefix_sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i< nums.length;i++) {
            prefix_sum+= nums[i];

            max = Math.max(prefix_sum, max);
            if (i!=0) {
                max = Math.max(max, prefix_sum - min);
            }
            min = Math.min(min, prefix_sum);
        }
        return max;
    }
    public static int kadaneAlgo(int[] nums) {

        int currSum = 0;
        int maxSub = nums[0];

        for (int i = 0;i< nums.length;i++) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += nums[i];
            maxSub = Math.max(maxSub ,  currSum);
        }
        return maxSub;
    }
}
