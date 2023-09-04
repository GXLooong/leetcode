package src;


public class leetcode283 {
    public static void main(String[] args) {
        int[] nums = {23, 0, 55, 0, 4};
        moveZeroes(nums);
        System.out.println(nums.toString());
    }
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while(j< nums.length){
            if(nums[j] != 0){
                nums[i++] = nums[j];
            }


            j++;
        }
        while(i< nums.length){
            nums[i++] = 0;
        }
    }
}
