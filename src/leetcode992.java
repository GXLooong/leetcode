package src;

import java.util.*;

public class leetcode992 {
    public static void main(String[] args) {
        // k个不同整数的子数组
    }

    public int subarraysWithKDistinct(int[] nums, int k){
        // 双指针可以处理最的情况，但是正好的情况却不好处理
        // 这里把正好转换成两个最的差，这种思想非常好！
        return atMostKthDistinct(nums, k) - atMostKthDistinct(nums, k-1);
    }

    public static int atMostKthDistinct(int[] nums, int k){
        int n = nums.length, l = 0, r = 0, count = 0; //count指示window中的不重复元素的个数
        int[] freq = new int[n+1];
        int ans = 0;
        // 不要只想着左定右动，右定左动也可以,以右侧为结尾的连续字串
        while(r < n){
            if(freq[nums[r]] == 0) count++;
            freq[nums[r]] ++;
            r++;
            while(count > k){
                freq[nums[l]] --;
                if(freq[nums[l]] == 0) count--;
                l++;
            }
            ans += r - l;
        }
        return ans;
    }
}
