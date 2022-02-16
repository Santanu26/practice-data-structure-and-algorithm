package basic;

import java.util.Arrays;

public class SearchItemFromArray {
    public static void main(String[] args) {
        int[] num1 = new int[] {-1,1,5,10};
        int[] num2 = new int[] {1};
        System.out.println(method(num1, 11));
        System.out.println(method(num1, -1));
        System.out.println(method(num2, 1));
        System.out.println(method(num2, 100));
    }
    public static boolean method(int[] nums, int k) {

        if (nums[0] == k) {
            return true;
        }
        return Arrays.binarySearch(nums, k)>0;
    }
}
