package hard;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Longest128 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,-1};
        System.out.println(method(nums));

    }

    public static int method(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }

        int max = 0;
        for (int i = 0; i < s.size(); i++) {
            int current = nums[i];
            int current_seq_length = 1;
            if (!s.contains(current - 1)) {
                while (s.contains(current +1)) {
                    current+=1;
                    current_seq_length+=1;
                }
                max = Math.max(current_seq_length, max);
            }
        }
        return max;
    }
}
