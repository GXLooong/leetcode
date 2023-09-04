package src;

import java.util.*;

public class leetcode239 {
    public static void main(String[] args) {
        // 滑动窗口的最大值
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ans = maxSlidingWindow(nums, 3);
        for(int i: ans){
            System.out.println(i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k){
        // 方法二
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        //queue里存的是还在window中的元素的下标，队首（最左端）是最大元素的下标
        Deque<Integer> queue = new ArrayDeque<>();
        // 前k个放入queue,得到ans[0]
        queue.addLast(0);
        for (int i = 1; i < k; i++) {
            while(!queue.isEmpty() && nums[i] > nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        ans[0] = nums[queue.getFirst()];
        // 遍历剩下的
        for(int i = k; i < n; i++){
            while(nums[i] > nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
            while(nums[queue.getFirst()] < i-k+1){
                queue.removeFirst();
            }
            ans[i-k+1] = nums[queue.getFirst()];
        }
        return ans;
    }
}
