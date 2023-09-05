package src;

public class leetcode35 {
    public static void main(String[] args) {
        // 搜索插入位置
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 2));
    }

    public static int searchInsert(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        while(start < end - 1){  //挨着就是要结束遍历
            int mid = (start + end)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target) return start;
        else if(nums[end] == target) return end;
        else if(nums[start] < target && nums[end] > target) {
            return end;
        }else if(nums[0] > target) return 0;
        return nums.length;
    }

}
