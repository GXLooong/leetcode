package src;

import java.util.HashMap;
import java.util.Map;

public class leetcode76 {
    public static void main(String[] args) {
        // 最小覆盖字串
        /*String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));*/
        char c = 'a', d = 'b';
        System.out.println(c);
    }

    public static String minWindow(String s, String  t){
        int slen = s.length(), tlen = t.length();
        // s的长度应该大于等于t的长度
        if(slen < tlen) return "";

        // 用两个map存储need（t中需要的）和window（窗口中有的）字符
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 遍历t得到need
        for(int i = 0; i < tlen; i++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        // 双指针滑动寻找最小字串的长度
        int left = 0, right = 0;
        int count = 0; // count指示window中有几个char达到了t中的个数
        int ansL = -1, ansR = -1;
        int minLen = Integer.MAX_VALUE;
        while(right < slen){
            char c = s.charAt(right);
            if(need.containsKey(c)){  // 只向window中添加t中存在的字符
                window.put(c, window.getOrDefault(c, 0)+1);
                if(need.get(c).equals(window.get(c))){  // 只有==的时候才能++count，不然在==之后的>会无线count++
                    count++;
                }
            }
            right++; // right用完了，可以++了

            // 左端缩进
            while(count == need.size()){ //window中满足条件的字符数够了，就可以开始左端缩进了,左端缩进的过程中会改变count,从而退出循环
                int len = right - left;
                if(len < minLen){  //更新
                    ansL = left;
                    ansR = right;
                    minLen = len;
                }
                // 左端缩进并更新count
                char cleft = s.charAt(left);
                if(need.containsKey(cleft)){  // 也只有need中有的char才会让count减少
                    if(need.get(cleft).equals(window.get(cleft))){
                        count--;
                    }
                    window.put(cleft, window.getOrDefault(cleft, 0)-1);
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE  ? "":s.substring(ansL, ansR); //不包含右端点
    }
}
