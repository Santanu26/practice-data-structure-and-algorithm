package variable_size_window;

public class Max1004 {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        // System.out.println(maxOnes(nums, k));
        //System.out.println(maxKZeros(nums, k));
        System.out.println(improvedVersion(nums, k));

    }

    public static int improvedVersion(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        for (int start = 0, end = 0, zero = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                zero++;

                while (zero > k) {
                    if (nums[start] == 0) {
                        zero--;
                    }
                    start++;
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static int maxKZeros(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        for (int start = 0; start < nums.length; start++) {
            for (int end = start, zero = 0; end < nums.length; end++) {
                if (nums[end] == 0) {
                    zero++;
                }
                if (zero <= k) {
                    max = Math.max(max, end - start + 1);
                } else {
                    break;
                }
            }
        }
        return max;
    }


    private static int maxOnes(int[] nums, int k) {
        int j = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {  // 0,1,2,3
                k--;  //0           // 1 0
            }
            if (k < 0) {
                if (nums[j] == 0) {
                    k++; // 1
                }
                j++;
            }

        }
        return i - j;

    }
}
