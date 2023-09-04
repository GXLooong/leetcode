package src;

import java.util.*;

public class leetcode437 {
    public static void main(String[] args) {
        // 二叉树路经总和
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public static int dfs(TreeNode root, Map<Long, Integer> prefix, long cur, int targetSum){
        // null返回
        if(root == null) return 0;

        // 其他操作
        int ans = 0;
        cur += root.val;

        ans = prefix.getOrDefault(cur - targetSum, 0);
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        ans += dfs(root.left, prefix, cur, targetSum);
        ans += dfs(root.right, prefix, cur, targetSum);
        prefix.put(cur, prefix.getOrDefault(cur,0) - 1);

        return ans;
    }
}
