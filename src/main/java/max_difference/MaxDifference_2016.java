package max_difference;

public class MaxDifference_2016 {
    public static void main(String[] args) {
        int[] arr = new int[]{1000, 2, 3, 10, 6, 4, 8, 1};
        int[] arr2 = new int[]{7, 9, 5, 6, 3, 2};
        int[] arr3 = new int[]{2, 5, 15, 6, 4};
        int[] arr4 = new int[] {87,68,91,86,58,63,43,98,6,40};
        System.out.println(maxDifference(arr));
        System.out.println(maxDifference2(arr));
        System.out.println("-------1st Array--------------");
        System.out.println(maxDifference(arr2));
        System.out.println(maxDifference2(arr2));

        System.out.println("--------3rd Array-------------");
        System.out.println(maxDifference(arr3));
        System.out.println(maxDifference3(arr3));

        System.out.println("----------4th Array-----------");
        System.out.println(maxDifference(arr4));
        System.out.println(maxDifference3(arr4));
    }

    public static int maxDifference(int[] arr) {
        int sum = Integer.MIN_VALUE;
        int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++) {
            for (int j = i + 1; j < arrLength; j++) {

                if (arr[i] < arr[j]) {

                    sum = Math.max(sum, arr[j] - arr[i]);
                }
            }
        }
        return sum;
    }

    public static int maxDifference3(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int len = arr.length;
        int max_so_far = arr[len-1];
        for (int i = len - 2; i >= 0; --i) {
            if (arr[i] < max_so_far) {
                ans = Math.max(ans, max_so_far - arr[i]);
            }
            max_so_far = Math.max(max_so_far, arr[i]);
        }
        return ans;
    }

    public static int maxDifference2(int[] arr) {
        int sum = Integer.MIN_VALUE;
        int len = arr.length;
        int j = 1;
        for (int i = 0; i < len; ) {
            if (j >= len) {
                return sum;
            }
            if (arr[i] < arr[j]) {
                sum = Math.max(sum, arr[j] - arr[i]);
                j++;
            } else {
                i++;
                j++;
            }
        }
        return sum;
    }

}
