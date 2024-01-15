package src;

import java.util.*;

public class leetocode78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, new ArrayList<Integer>());
        return res;
    }

    public static void backtrack(List<List<Integer>> res, int[] nums, int startIdx, ArrayList<Integer> path){
        // 直接添加
        res.add(new ArrayList<>(path));

        for (int i = startIdx; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(res, nums, i+1, path);
            path.remove(path.size()-1);
        }


    }
}
