package src;

public class leetcode48 {
    public static void main(String[] args) {
        // 旋转图像
        // 给矩阵分层的可真是一个好方法
    }

    public void rotate(int[][] matrix){
        int n = matrix.length;
        int left = 0, right = n-1, top = 0, bottom = n-1;
        while(left < right && top < right){
            for (int idx = 0; idx < right - left; idx++) {
                int restore = matrix[left][top];
                // 从左到右  left+1 --> right
                for(int j = left + 1; j <= right; j++){
                    int temp = matrix[top][j];
                    matrix[top][j] = restore;
                    restore = temp;
                }
                // 从右往下  top+1 --> bottom
                for (int i = top+1; i <= bottom; i++) {
                    int temp = matrix[i][right];
                    matrix[i][right] = restore;
                    restore = temp;
                }
                //从下往左  right-1 -->left
                for(int j = right-1; j >= left; j--){
                    int temp = matrix[bottom][j];
                    matrix[bottom][j] = restore;
                    restore = temp;
                }
                // 从左往上  bottom-1 --> top
                for (int i = bottom-1; i >= top; i--) {
                    int temp = matrix[i][left];
                    matrix[i][left] = restore;
                    restore = temp;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}
