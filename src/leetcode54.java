package src;

import java.util.ArrayList;
import java.util.List;

public class leetcode54 {
    public static void main(String[] args) {
        // 螺旋矩阵
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> ans = spiralOrder(matrix);
    }
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        // 用于辅助的内存空间，在分配前必须检查是否需要分配，会节省大量的内存空间
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        // 用posi,posj 指示当前的位置，用upFlag表示上一步是否为上行
        int posi = 0, posj = 0;
        boolean upFlag = false;
        for(int i = 0; i < m * n; i++){
            ans.add(matrix[posi][posj]);
            visited[posi][posj] = true;
            // 按照右下左上的顺序进行遍历,但如果上一步是上行，应优先往上走而不是往右走
            if(upFlag && (posi - 1) >= 0 && visited[posi-1][posj] == false){
                posi --;
            }else if((posj + 1) < n && visited[posi][posj+1] == false){
                posj ++;
                upFlag = false;
            }else if((posi + 1) < m && visited[posi+1][posj] == false){
                posi++;
                upFlag = false;
            }else if((posj -1) >= 0 && visited[posi][posj-1] == false){
                posj --;
                upFlag = false;
            }else{
                posi --;
                upFlag = true;
            }
        }
        return ans;
    }
}
