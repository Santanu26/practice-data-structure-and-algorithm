package rev;

import static java.lang.Math.min;

public class MaxArea {
    //  Input: height = [1,8,6,2,5,4,8,3,7]
    //  Output: 49
    public static void main(String[] args) {

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxAreaWaterContain(height));
    }

    public static int maxAreaWaterContain(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int result = 0;

        while (left < right) {
            area = (right - left) * min(height[left], height[right]);

            result = Math.max(area, result);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

}
