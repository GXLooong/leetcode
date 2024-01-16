package src;

import java.util.ArrayList;
import java.util.List;

public class leetcode39 {

    // List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> res = combinationSum(candidates, 7);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 先假设数组是升序排列的
        // 所以暂时不做sort处理
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int start, int target){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int target_ = target;
            List<Integer> path_ = new ArrayList<>(path);
            while(target - candidates[i] >= 0){
                target -= candidates[i];
                path.add(candidates[i]);
                dfs(res, new ArrayList<>(path), candidates, i+1, target);
            }
            target = target_;
            path = path_;
        }
    }
}
