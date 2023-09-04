package src;

public class leetcode543 {
    public static void main(String[] args) {
        // 二叉树的直径
        int[] nums = {3,1,-1,-1,2};
        TreeNode root = TreeNode.buildTree(nums);
        int[] ans = getHeight(root);
        System.out.println(ans[1]);
    }

    public int diameterOfBinaryTree(TreeNode root){
        return getHeight(root)[1];
    }


    public static int[] getHeight(TreeNode root){
        // 返回的int[]中有两个值，第一个为height,第二个为直径
        int[] ans = new int[2];
        // 根节点
        if(root == null) {
            ans[0] = 0;
            ans[1] = 0;
            return ans;
        }
        // 非根节点
        int[] left = getHeight(root.left);
        int[] right = getHeight(root.right);
        ans[0] = Math.max(left[0], right[0]) + 1;
        ans[1] = Math.max(Math.max(left[1], right[1]), left[0] + right[0]);
        return ans;
    }



}
