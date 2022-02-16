package basic;

import java.util.Arrays;

public class CountingBits338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingBitsBruteForce(5)));
        System.out.println(Arrays.toString(countingBitsWithDp(5)));
    }

    public static int[] countingBitsWithDp(int num) {
        int[] res = new int[num+1];
        for (int i = 1;i<= num;i++) {
            res[i] = res[i>>1] + (i&1);
        }
        return res;
    }
    public static int[] countingBitsBruteForce(int num) {

        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= num; i++) {
            result[i] = countBinaryDigits(i);
        }
        return result;
    }

    public static int countBinaryDigits(int idx) {
        int res = 0;
        while (idx > 0) {
            res = res + (idx & 1);
            idx = idx >> 1;
        }
        return res;
    }
}
