package max_difference;

public class MaxDiffPractice {
    public static void main(String[] args) {

        int[] arr = new int[]{1000, 2, 3, 10, 6, 4, 8, 1};
        int[] arr2 = new int[]{7, 9, 5, 6, 3, 2};
        int[] arr3 = new int[]{2, 5, 15, 6, 4};
        int[] arr4 = new int[] {87,68,91,86,58,63,43,98,6,40};
        System.out.println(maxDiff(arr));
        System.out.println(maxDiff(arr));
        System.out.println("-------1st Array--------------");
        System.out.println(maxDiff(arr2));
        System.out.println(maxDiff(arr2));

        System.out.println("--------3rd Array-------------");
        System.out.println(maxDiff(arr3));
        System.out.println(maxDiff(arr3));

        System.out.println("----------4th Array-----------");
        System.out.println(maxDiff(arr4));
        System.out.println(maxDiff(arr4));

    }

    public static int maxDiff(int[] nums) {

        int ans = Integer.MIN_VALUE;
        int max = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < max) {
                ans = Math.max(ans, max - nums[i]);
            }
            max = Math.max(max,nums[i] );
        }
        return ans;
    }
}
