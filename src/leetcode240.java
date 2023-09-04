package src;

public class leetcode240 {
    public static void main(String[] args) {
        // 搜索排序好的二维矩阵
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix, 5));;

    }

    public static boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int rowSide = m, colSide = n;
        // rowSide和colSide表示过大的边界，边界及边界之外不会查找
        // 先找出rowSide和colSide
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == target) return true;
            else if(matrix[0][j] > target){
                colSide = j;
                break;
            }
        }
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == target) return true;
            else if(matrix[i][0] > target){
                rowSide = i;
                break;
            }
        }
        // 遍历两个边界内的元素
        for (int i = 0; i < rowSide; i++) {
            if(binarySearch(matrix[i], 0, colSide -1, target) != -1) return true;
        }
        return false;
    }

    public static int binarySearch(int[] nums, int start, int end, int target){
        while(end >= start){
            int mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) end = mid -1;
            else start = mid + 1;
        }
        return -1;
    }
}
