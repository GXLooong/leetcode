package src;



import java.util.*;

public class leetcode41 {
    public static void main(String[] args) {
        // 缺失的第一个正数
    }

    public int firstMissingPositive(int[] nums){
        // 排序
        Arrays.sort(nums);
        // 找到第一个正数的idx
        int firstPositiveIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                firstPositiveIdx = i;
                break;
            }
        }
        // 如果全是负数  或者  第一个大于1
        if(firstPositiveIdx == -1 || nums[firstPositiveIdx] > 1) return 1;

        // 上面不返回1，就说明第一个正数一定是1
        // 那么从1往后遍历，如果不连续，就可以得出结果
        for(int i = firstPositiveIdx+1; i < nums.length; i++){
            // 如果整数不连续，就可以得出结论了
            if(nums[i] - nums[i-1] > 1){
                return nums[i-1] + 1;
            }
        }
        // 如果全都连续，那么就是最后一个元素 +1
        return nums[nums.length-1] + 1;
    }
}
