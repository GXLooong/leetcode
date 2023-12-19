package src;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author GXL
 * @Date create in 2023/12/19 20:07
 */
public class leetcode827 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1},
                {1, 1}
        };

    }

    public int largestIsland(int[][] grid) {
        // 下标是岛屿编号，值为编号对应岛屿的面积
        ArrayList<Integer> areas = new ArrayList<>();

        //idx表示第几个岛屿
        int idx = 0;
        int maxArea = 0;
        // 第一遍遍历，讲grid中同一岛屿位置的值填充为岛屿编号+2（因为要避开0和1）
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    //
                    int area = dfs(grid, i, j, idx + 2);
                    areas.add(idx++, area);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        // 第一遍遍历后，grid就只有0和2以上的数了
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                // 0表示海洋，就要开始判断了
                if (grid[i][j] == 0) {
                    // 存储出现过的岛屿idx
                    HashSet<Integer> set = new HashSet<>();
                    int ansTmp = 1;
                    // 上
                    if (i - 1 >= 0 && grid[i - 1][j] != 0) {
                        ansTmp += areas.get(grid[i - 1][j] - 2);
                        set.add(grid[i - 1][j] - 2);
                    }
                    // 下
                    if (i + 1 < grid.length && grid[i + 1][j] != 0 && !set.contains(grid[i + 1][j] - 2)) {
                        ansTmp += areas.get(grid[i + 1][j] - 2);
                        set.add(grid[i + 1][j] - 2);
                    }
                    // 左
                    if (j - 1 >= 0 && grid[i][j - 1] != 0 && !set.contains(grid[i][j - 1] - 2)) {
                        ansTmp += areas.get(grid[i][j - 1] - 2);
                        set.add(grid[i][j - 1] - 2);
                    }
                    // 右
                    if (j + 1 < grid.length && grid[i][j + 1] != 0 && !set.contains(grid[i][j + 1] - 2)) {
                        ansTmp += areas.get(grid[i][j + 1] - 2);
                        set.add(grid[i][j + 1] - 2);
                    }
                    maxArea = Math.max(maxArea, ansTmp);
                }
            }
        }
        return maxArea;
    }


    public static int dfs(int[][] grid, int row, int col, int index) {
        // 越界检查
        if (!(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length)) {
            return 0;
        }

        // 遍历过或者不是陆地
        if (grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = index;
        return dfs(grid, row - 1, col, index) + dfs(grid, row + 1, col, index)
                + dfs(grid, row, col - 1, index) + dfs(grid, row, col + 1, index) + 1;
    }


}
