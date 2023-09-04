package src;
import java.util.*;

public class leetcode101 {
    public static void main(String[] args) {
        // 对称二叉树
    }

    public boolean isSymmetric(TreeNode root){
        return check(root.left, root.right);
    }
    public boolean check(TreeNode left, TreeNode right){
        /*if(left == null && right == null) return true;
        if(left == null || right == null) return false;*/
        if (left == null || right == null){
            return left == right;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
    /*public boolean isSymmetric(TreeNode root) {
        List<Integer> leftInorder = Inorder(root.left, 1);
        List<Integer> rightInorder = Inorder(root.right, -1);
        // 如果数量不等，直接返回false即可
        if(leftInorder.size() != rightInorder.size()) return false;

        List<Integer> leftLayer = LayerOrder(root.left, 1);
        List<Integer> rightLayer = LayerOrder(root.right, -1);

        // 数量相等，再进行判断
        for (int i = 0; i < leftInorder.size(); i++) {
            if((leftInorder.get(i) != rightInorder.get(i)) || (leftLayer.get(i) != rightLayer.get(i))){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> Inorder(TreeNode root, int tag){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        // tag表示中序遍历的顺序，若为1，则为左中右；若为-1，则为右中左
        if(tag == 1){
            ans.addAll(Inorder(root.left, tag));
            ans.add(root.val);
            ans.addAll(Inorder(root.right, tag));
        }else if(tag == -1){
            ans.addAll(Inorder(root.right, tag));
            ans.add(root.val);
            ans.addAll(Inorder(root.left, tag));
        }else{
            throw new RuntimeException("Inorder函数传入的tag只能为1或者-1");
        }
        return ans;
    }

    public static List<Integer> LayerOrder(TreeNode root, int tag){
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        // 层序遍历,需要队列
        if(root == null) return ans;
        deque.addLast(root);
        while(!deque.isEmpty()){
            TreeNode tmp = deque.removeFirst();
            ans.add(tmp.val);
            if(tag == 1){
                if(tmp.left!=null) deque.addLast(tmp.left);
                if(tmp.right!=null) deque.addLast(tmp.right);
            }else if(tag == -1){
                if(tmp.right!=null) deque.addLast(tmp.right);
                if(tmp.left!=null) deque.addLast(tmp.left);
            }else{
                throw new RuntimeException("Inorder函数传入的tag只能为1或者-1");
            }
        }
        return ans;
    }*/
}
