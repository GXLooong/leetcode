package src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class leettcode114{
    public static void main(String[] args) {
        int[] nums = {1,2,5,3,4,-1,6};
        TreeNode root = TreeNode.buildTree(nums);
        //对比
        TreeNode.printLevelOrder(root);
        flatten(root);
        TreeNode.printLevelOrder(root);
    }
    public static void flatten(TreeNode root) {
        ArrayList<Integer> preOrderlist = new ArrayList<Integer>();
        //存储先序遍历的结果
        preOrder(root, preOrderlist);
        //创建新的二叉树存储结果
        if(root != null){
            root = create(preOrderlist, 0);
        }
    }

    public static void preOrder(TreeNode root, ArrayList<Integer> preOrderList){
        if(root != null){
            preOrderList.add(root.val);
        }else{
            return;
        }
        preOrder(root.left, preOrderList);
        preOrder(root.right, preOrderList);

    }
    public static TreeNode create(ArrayList<Integer> preOrderlist, int index){
        TreeNode result = new TreeNode();
        if(index < preOrderlist.size()){
            result.val = preOrderlist.get(index);
        }else{
            return null;
        }
        result.left = null;
        result.right = create(preOrderlist, index+1);
        return result;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            TreeNode node = queue.poll();

            // 构建左子节点
            if (nums[i] != -1) {
                TreeNode left = new TreeNode(nums[i]);
                node.left = left;
                queue.offer(left);
            }
            i++;

            // 构建右子节点
            if (i < nums.length && nums[i] != -1) {
                TreeNode right = new TreeNode(nums[i]);
                node.right = right;
                queue.offer(right);
            }
            i++;
        }

        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.print("-1 ");
                continue;
            }

            System.out.print(node.val + " ");

            queue.offer(node.left);
            queue.offer(node.right);
        }
    }
}