package src;

public class leetcode238 {
    public static void main(String[] args) {

    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preMul = new int[n];
        int [] afterMul = new int[n];
        int[] ans = new int[n];

        // 计算preMul和afterMul
        preMul[0] = 1;
        afterMul[n-1] = 1;
        int preM = 1, afterM = 1;
        for(int i = 0; i < n-1; i++){
            preM *= nums[i];
            preMul[i+1] = preM;
            afterM *= nums[n-1-i];
            afterMul[n-2-i] = afterM;
        }

        // 计算结果
        for (int i = 0; i < n; i++) {
            ans[i] = preMul[i] * afterMul[i];
        }
        return ans;
    }
}
