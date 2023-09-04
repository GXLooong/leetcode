package src;

import java.util.Arrays;

public class leetcode3 {
    public static void main(String[] args) {
        // 无重复字符的最长字串
    }
    public int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0) return 0;
        // 动态规划 + 辅助数组
        int n = s.length();
        int[] dp = new int[n]; // 表示以s.charAt(i)为结尾的最长字串的长度
        int[] last_pos = new int[128];  // 存储s.charAt(i)最近一次出现的位置
        Arrays.fill(last_pos, -1);
        // 初始化
        int maxlen = 1;
        dp[0] = 1;
        last_pos[s.charAt(0)] = 0;
        // 遍历，更新
        for (int i = 1; i < n; i++) {
            if(i - last_pos[s.charAt(i)] > dp[i-1]){ // 如果在前一个元素为结尾的最长字串之外
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = i - last_pos[s.charAt(i)];
            }
            maxlen = Math.max(maxlen, dp[i]);
            last_pos[s.charAt(i)] = i;
        }
        return maxlen;


        /*int len = s.length();
        if(s == null || len == 0) return 0;
        boolean[] need = new boolean[128];  // 某char是否出现
        int right = 0, maxlen = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            while(right < len && need[s.charAt(right)] == false){  // right指针右移,停在第一个重复的元素上
                need[s.charAt(right)] = true;
                right++;
            }
            maxlen = Math.max(maxlen, right - i);  // 挑战最大长度
            need[s.charAt(i)] = false;
        }
        return maxlen;*/
    }
}
