package src;

import java.util.*;

public class leetcode94 {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();

        // 方法一：递归实现
//        if(root == null){
//            return ans;
//        }
//        List<Integer> leftAns = inorderTraversal(root.left);
//        List<Integer> rightAns = inorderTraversal(root.right);
//
//        //将左右和中间的元素按顺序集成到ans中
//        ans.addAll(leftAns);
//        ans.add(root.val);
//        ans.addAll(rightAns);
//        return ans;

        // 方法二: 利用栈，迭代实现
        Deque<TreeNode> deque = new ArrayDeque<>();

        while(root != null || !deque.isEmpty()){
            // 左子树入栈，直至root为null
            while(root!=null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            ans.add(root.val);
            root = root.right;
        }

        return ans;
    }
}
