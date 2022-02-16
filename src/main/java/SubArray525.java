import java.util.HashMap;

public class SubArray525 {
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,1,1};

        System.out.println(subArray(nums));

    }
    public static int subArray(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(0,-1);

        int sum = 0;

        for (int i = 0;i< nums.length;i++) {
            if (nums[i]==0) nums[i]=-1;
        }
        int max = 0;
        for (int i = 0;i< nums.length;i++) {
            sum+=nums[i];

            if (hashMap.containsKey(sum)) {
                max= Math.max(max,i-hashMap.get(sum));
            } else {

                hashMap.put(sum, i);
            }
        }
        return max;
    }
}
