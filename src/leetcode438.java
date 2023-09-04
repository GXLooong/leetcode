package src;
import java.util.*;

public class leetcode438 {
    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        List<Integer> ans = findAnagrams(s, p);
        System.out.println(ans);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<Integer>(){};
        List<Integer> ans = new ArrayList<>();
        int slen = s.length(), plen = p.length();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        p = new String(chars);
        for(int i = 0; i <= (slen - plen); i++){
            if(isAllotopic(s.substring(i, i+plen), p)){
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean isAllotopic(String a, String b){
        // 没必要很麻烦，又用map又用set的，直接排序完equal就好了！！
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        a = new String(chars);
        return a.equals(b);
    }

}
