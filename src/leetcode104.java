package src;

public class leetcode104 {
    public static void main(String[] args) {
        // 二叉树的最大深度

    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
