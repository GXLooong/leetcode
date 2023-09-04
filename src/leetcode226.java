package src;

public class leetcode226 {
    public static void main(String[] args) {
        //反转二叉树
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        // 交换处理后的左右子树
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }
}
