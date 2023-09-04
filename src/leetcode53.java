package src;

public class leetcode53 {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //状态转移方程
            pre = Math.max(nums[i], nums[i]+pre);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
}
