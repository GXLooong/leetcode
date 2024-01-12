package src;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

@SuppressWarnings({"all"})
public class leetcode98 {
    public static void main(String[] args) {
        // 验证二叉搜索树

    }

    public boolean isValidBST(TreeNode root){
        // 上下界方法
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, long lower, long upper){
        if(root == null) return true;
        if(root.val <= lower || root.val >= upper) return false;
        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }
    /*public boolean isValidBST(TreeNode root){
        // 迭代的中序遍历方法
        Deque<TreeNode> stack = new ArrayDeque<>();
        long pre = Long.MIN_VALUE;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= pre) return false;
            pre = root.val;
            root = root.right;
        }
        return true;
    }*/

    /*public boolean isValidBST(TreeNode root){
        ArrayList<Integer> inorder = InOrder(root);
        for(int i = 1; i < inorder.size(); i++){
            if(inorder.get(i) <= inorder.get(i-1)) return false;
        }
        return true;
    }

    public static ArrayList<Integer> InOrder(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        ans.addAll(InOrder(root.left));
        ans.add(root.val);
        ans.addAll(InOrder(root.right));
        return ans;
    }*/
}
