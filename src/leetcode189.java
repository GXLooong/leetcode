package src;

public class leetcode189 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for(int num:nums){
            System.out.println(num);
        }
    }

    public static void rotate(int[] nums, int k) {
        // 取余得到真正要移动的步数
        int n = nums.length;
        k = k % nums.length;

        // count表示总共要走几遍
        int count = gcd(n, k);
        for (int i = 0; i < count; i++) {
            int prev = nums[i];
            int current = (i + k) % n;
            while(current != i){
                // 交换
                int tmp = nums[current];
                nums[current] = prev;
                prev = tmp;
                current = (current + k) % n;
            }
            nums[i] = prev;
        }

    }

    public static int gcd(int x, int y){
        return y > 0 ? gcd(y, x % y) : x;
    }

}
