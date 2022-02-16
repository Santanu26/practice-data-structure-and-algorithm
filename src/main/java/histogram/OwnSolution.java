package histogram;

import java.util.Stack;

public class OwnSolution {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        System.out.println(maxArea(mat));
    }

    public static int maxHistoGramAlgo(int[] row) {

        Stack<Integer> result = new Stack<>();

        int idx = 0;
        int topValue;
        int area;
        int maxArea = 0;
        while (idx < row.length) {
            if (result.empty() || row[result.peek()] <= row[idx]) {
                result.push(idx++);
            } else {
                topValue = row[result.peek()];
                result.pop();
                area = topValue * idx;

                if (!result.empty()) {
                    area = topValue * (idx - result.peek() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!result.empty()) {
            topValue = row[result.peek()];
            result.pop();
            area = topValue * idx;
            if (!result.empty()) {
                area = topValue * (idx - result.peek() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;

    }

    public static int maxArea(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int result = maxHistoGramAlgo(mat[0]);

        for (int r = 1; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (mat[r][c] == 1) {
                    mat[r][c] += mat[r - 1][c];
                }
            }
            result = Math.max(result, maxHistoGramAlgo(mat[r]));
        }
        return result;
    }
}
