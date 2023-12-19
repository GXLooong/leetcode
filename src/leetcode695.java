package src;

/**
 * @author GXL
 * @Date create in 2023/12/19 19:53
 */
public class leetcode695 {
    public static void main(String[] args) {

    }


    public static int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    public static int dfs(int[][] grid, int row, int col) {
        // 越界检查
        if (!(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length)) {
            return 0;
        }

        // 遍历过或者不是陆地
        if (grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = 2;
        return dfs(grid, row - 1, col) + dfs(grid, row + 1, col)
                + dfs(grid, row, col - 1) + dfs(grid, row, col + 1) + 1;
    }
}
