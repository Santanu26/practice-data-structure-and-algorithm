package hard;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[] {0,0,-1};
        System.out.println(method(nums));

    }
    public static int method(int[] nums) {

        Set<Integer> s = new HashSet<>();

        for (int i = 0;i< nums.length;i++) {
            s.add(nums[i]);
        }
        int max_seq = 0;

        for (int i = 0;i< nums.length;i++) {
            int current_num = nums[i];
            int current_seq = 1;

            if (!s.contains(current_num-1)) {
                while(s.contains(current_num+ 1)) {
                    current_num+=1;
                    current_seq+=1;
                }
                max_seq = Math.max(max_seq, current_seq);
            }
        }
        return max_seq;
    }
}
