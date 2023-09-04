package src;

public class leetcode105 {
    public static void main(String[] args) {
        // 由前序遍历和中序遍历构造二叉树

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int[] inorder, int rootIdx, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[rootIdx]);

        // 找到mid
        int mid = -1;
        for(int i = start; i <= end; i++){
            if(preorder[rootIdx] == inorder[i]){
                mid = i;
                break;
            }
        }


        // 递归左右子树
        root.left = build(preorder, inorder, rootIdx+1, start, mid-1);
        root.right = build(preorder, inorder, rootIdx+mid-start+1, mid+1, end);

        return root;
    }

}
