package src;
import java.util.*;

public class leetcode102 {
    public static void main(String[] args) {
        // 层序遍历，但不是最简单的
        // 而是每一层单独打印出来,存入queue时，再存入一个层数就好了。
        int[] nums = {3,9,20,-1,-1,15,7};
        TreeNode root = TreeNode.buildTree(nums);
        List<List<Integer>> level = levelOrder(root);

    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        // 如果为空，直接返回
        if(root == null) return ans;

        // nodeQ存储node节点，layerQ存储对应位置的node所在哪一层，current表示现在在哪一层
        Deque<TreeNode> nodeQ = new ArrayDeque<>();
        Deque<Integer> layerQ = new ArrayDeque<>();
        int current = 0;  // 表示开始在root时是第0层

        // method
        nodeQ.addLast(root);
        layerQ.addLast(0);
        List<Integer> levelList = new ArrayList<>();
        while(!nodeQ.isEmpty()){
            // 弹出
            TreeNode temp = nodeQ.removeFirst();
            int status = layerQ.removeFirst();

            // 挤入
            if(temp.left != null){
                nodeQ.addLast(temp.left);
                layerQ.addLast(status+1);
            }
            if(temp.right != null){
                nodeQ.addLast(temp.right);
                layerQ.addLast(status+1);
            }

            // 生成遍历结果
            if(status == current){
                levelList.add(temp.val);
            }else{
                List<Integer> alter = new ArrayList<>();
                alter.addAll(levelList);
                ans.add(alter);
                levelList.clear();
                levelList.add(temp.val);
                current = status;
            }
        }
        if(!levelList.isEmpty()) ans.add(levelList);
        return ans;
    }
}
