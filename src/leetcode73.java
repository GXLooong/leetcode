package src;
import java.util.*;

public class leetcode73 {
    public static void main(String[] args) {
        // 矩阵置零
    }
    public void setZeroes(int[][] matrix){
        boolean flagCol0 = false;
        int m = matrix.length, n = matrix[0].length;
        // 遍历第一列，将第一列是否需要置零存入flagCol0
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                flagCol0 = true;
                break;
            }
        }
        // 遍历第一行，matirx[0]存储第一行是否需要置零,如果为0，就表示需要置零，如果不是，就表示不需要
        for (int j = 0; j < n; j++) {
            if(matrix[0][j] == 0){
                matrix[0][0] = 0;
                break;
            }
        }
        // 将第一行和第一列当作标记数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        // 根据第一行和第一列存的结果对内部置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // 对第一行和第一列置零
        if(matrix[0][0] == 0){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if(flagCol0){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }

    /*public void setZeroes(int[][] matrix){
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        int m = matrix.length, n = matrix[0].length;

        // 找出所有需要置零的行和列，分别存入set中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        *//*for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if(rowSet.contains(i) || colSet.contains(j)) matrix[i][j] = 0;
            }
        }*//*
        // 行置零
        for(int i:rowSet){
            for(int j = 0; j < n; j++){
                matrix[i][j] = 0;
            }
        }
        // 列置零
        for(int j:lineSet){
            for(int i = 0; i < m; i++) matrix[i][j] = 0;
        }
    }*/
}
