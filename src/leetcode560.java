package src;

import java.util.HashMap;

public class leetcode560 {
    public static void main(String[] args) {
        // 和为k的数组
    }

    public int subarraySum(int[] nums, int k){
        int pre = 0, count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);  // 很重要
        for(int i = 0; i < nums.length; i++){
            pre += nums[i];
            int temp = mp.getOrDefault(pre - k, 0);
            count += temp;
            mp.put(pre, mp.getOrDefault(pre, 0)+1);
        }
        return count;



        /*int count = 0;
        for(int end = 0; end < nums.length; end++){
            int sum = 0;
            for(int start = end; start >= 0; start--){
                sum += nums[start];
                if(sum == k) count++;
            }
        }
        return count;*/
    }
}
