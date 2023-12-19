package src;

/**
 * @author GXL
 * @Date create in 2023/12/19 17:47
 */
public class leetcode200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        // dfs统一框架
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int rowIdx, int colIdx) {
        // 判断是否越界
        if (!(rowIdx >= 0 && rowIdx < grid.length && colIdx >= 0 && colIdx < grid[0].length)) {
            return;
        }

        // 如果遍历过或者是水，直接返回
        if (grid[rowIdx][colIdx] != '1') {
            return;
        }

        grid[rowIdx][colIdx] = '2';

        dfs(grid, rowIdx - 1, colIdx);
        dfs(grid, rowIdx + 1, colIdx);
        dfs(grid, rowIdx, colIdx - 1);
        dfs(grid, rowIdx, colIdx + 1);
    }
}
