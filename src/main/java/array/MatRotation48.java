package array;

import java.util.Arrays;

public class MatRotation48 {
    public static void main(String[] args) {

        //int[][] mat = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(mat);

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat.length; c++) {
                System.out.print(mat[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] mat) {
        transpose(mat);
        reflect(mat);
    }

    public static void transpose(int[][] mat) {
        int size = mat.length;

        for (int r = 0; r < size; r++) {
            for (int c = r + 1; c < size; c++) {
                swap(r, c, mat);
            }
        }
    }

    public static void reflect(int[][] mat) {

        int size = mat.length;

        for (int r = 0; r < size ; r++) {
            for (int c = 0; c < size/2; c++) {
                //swap(r, size - c - 1, mat);
                int tmp = mat[r][c];
                mat[r][c] = mat[r][size-c-1];
                mat[r][size-c-1] = tmp;
            }
        }
    }

    private static void swap(int r, int c, int[][] mat) {
        int tmp = mat[r][c];
        mat[r][c] = mat[c][r];
        mat[c][r] = tmp;
    }
}
