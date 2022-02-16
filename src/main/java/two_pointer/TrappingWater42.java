package two_pointer;

public class TrappingWater42 {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(method(height));
    }

    public static int method(int[] height) {
        int ans = 0,left = 0, right = height.length - 1, curr = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                curr = left;
                while (++left < curr) {
                    ans += height[curr] - height[left];
                }
            } else {
                curr = right;
                while (--right < curr) {
                    ans += height[right] - height[curr];
                }
            }
        }
        return ans;
    }
}
