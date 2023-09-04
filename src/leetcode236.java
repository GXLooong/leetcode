package src;

public class leetcode236 {
    public static void main(String[] args) {
        // 二叉树的最近公共祖先
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // null
        if(root == null || root == p || root == q) return root;

        // root既不是null,也不是p,q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;

        if(left == null && right == null) return null;
        return left == null? right : left;

        /*
        * 思路：
        *   只会返回p和q以及夹在p和q之间的第一个root,否则都是null
        *
        * if(left == null && right == null) return null;
        return left == null? right : left;
        *
        * 跟直接后半句效果是一样的！  如果两个都是null，就返回null,如果只有一个null,那就返回不是null的那一个
        * */


    }
}
