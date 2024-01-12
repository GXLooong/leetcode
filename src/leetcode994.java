package src;

import java.util.LinkedList;

/**
 * @author GXL
 * @Date create in 2023/12/26 14:17
 */
public class leetcode994 {
    public static void main(String[] args) {
        int[][] gird = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(gird));
    }

    // bfs
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 计算总的新鲜橘子的数量，等到bfs遍历结束后，如果没有减为0，就说明有感染不到的橘子
        int countFresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }
        if(countFresh == 0){
            return 0;
        }
        // bfs模拟感染的过程
        LinkedList<MatrixIndex> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2){
                    queue.offer(new MatrixIndex(i, j));
                }
            }
        }
        int deepth = 0;
        while(!queue.isEmpty()){
            deepth++;
            int num = queue.size();
            for (int ids = 0; ids < num; ids++) {
                MatrixIndex mi = queue.poll();
                int i = mi.getI();
                int j = mi.getJ();
                // 感染上下左右
                // 上
                if(i-1>=0 && grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    countFresh --;
                    queue.offer(new MatrixIndex(i-1, j));
                }
                // 下
                if(i+1<m && grid[i+1][j] == 1) {
                    grid[i + 1][j] = 2;
                    countFresh --;
                    queue.offer(new MatrixIndex(i+1, j));
                }
                // 左
                if(j-1>=0 && grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    countFresh --;
                    queue.offer(new MatrixIndex(i, j-1));
                }
                // 右
                if(j+1<n && grid[i][j+1] == 1){
                    grid[i][j+1] = 2;
                    countFresh --;
                    queue.offer(new MatrixIndex(i, j+1));
                }
            }
        }
        if(countFresh != 0){
            return -1;
        }
        return deepth-1;
    }
    // 静态内部类，用来封装下标
    static class MatrixIndex {
        int i; // 行索引
        int j; // 列索引

        // 构造函数
        public MatrixIndex(int i, int j) {
            this.i = i;
            this.j = j;
        }

        // 获取行索引
        public int getI() {
            return i;
        }

        // 获取列索引
        public int getJ() {
            return j;
        }

        // 用于打印下标的toString方法
        @Override
        public String toString() {
            return "(" + i + ", " + j + ")";
        }
    }
    /*public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        int count = 0; // 经过几分钟
        while(true){
            // 表示是否还有新鲜水果，先假设没有
            boolean tag = false;
            // 判断是否还有新鲜苹果
            for (int i = 0; i < m; i++) {
                if(!tag){
                    for (int j = 0; j < n; j++) {
                        // 发现新鲜水果，要结束两层循环
                        if(grid[i][j] == 1){
                            tag = true;
                            break;
                        }
                    }
                }
            }
            // 的确没有新鲜水果了
            if(!tag){
                break;
            }
            // 先进行感染过程
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 只“感染”就可以
                    if(grid[i][j] == 2){
                        // 上
                        if(i-1>=0 && grid[i-1][j] == 1){
                            grid[i-1][j] = 2;
                        }
                        // 下
                        if(i+1<m && grid[i+1][j] == 1) {
                            grid[i + 1][j] = 2;
                        }
                        // 左
                        if(j-1>=0 && grid[i][j-1] == 1){
                            grid[i][j-1] = 2;
                        }
                        // 右
                        if(j+1<n && grid[i][j+1] == 1){
                            grid[i][j+1] = 2;
                        }

                    }else if(grid[i][j] == 1){
                        // 判断是否四周没有橘子
                        // 上有
                        if(i-1>=0 && grid[i-1][j] != 0){
                            continue;
                        }
                        // 下有
                        if(i+1<m && grid[i+1][j] != 0) {
                            continue;
                        }
                        // 左有
                        if(j-1>=0 && grid[i][j-1] != 0){
                            continue;
                        }
                        // 右有
                        if(j+1<n && grid[i][j+1] != 0){
                            continue;
                        }
                        // 如果四周都没有橘子
                        return -1;
                    }
                }
            }
            count++;
        }

        return count;
    }*/
}
