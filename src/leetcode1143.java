package src;

public class leetcode1143{
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence(new String("adfd"), "dfsdff"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // f[][]状态数组
        int[][] f = new int[n+1][m+1];
        
        // 状态转移方法
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){ 
                    // 如果字符相同
                    f[i][j] = f[i-1][j-1] + 1;
                }else{ 
                    // 如果字符不同
                    f[i][j]  = Math.max(f[i-1][j], f[i][j-1]);
                }       
            }
        }
        return f[n][m];
    }
}