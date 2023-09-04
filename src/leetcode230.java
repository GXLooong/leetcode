package src;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode230 {
    public static void main(String[] args) {
        // 二叉搜索树中第K小的元素

    }

    public int kthSmallest(TreeNode root, int k){
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            k--;
            root = stack.pop();
            if(k == 0) return root.val;
            root = root.right;
        }
        return 0;
    }
}
