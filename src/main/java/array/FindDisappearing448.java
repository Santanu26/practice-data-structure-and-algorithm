package array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearing448 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1};
        System.out.println(method(nums));
    }
    public static List<Integer> method(int[] nums) {

        int[] n = new int[nums.length +1];

        for (Integer num: nums) {
            n[num] = num;
        }

        List<Integer> missingNumber = new ArrayList<>();
        for (int i = 1;i<= nums.length;i++) {
            if (n[i] ==0) {
                missingNumber.add(i);
            }
        }
        return missingNumber;
    }
}
