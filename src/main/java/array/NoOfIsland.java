package array;

public class NoOfIsland {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;

        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c) {

        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0';  // very careful

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

}
