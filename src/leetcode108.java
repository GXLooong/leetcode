package src;

public class leetcode108 {
    public static void main(String[] args) {
        // 将有序数组转换为二叉搜索树
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public static TreeNode build(int[] nums, int begin, int end){
        // 递归返回条件
        if(begin > end) return null;

        // 建树
        int mid = (begin + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, begin, mid-1);
        root.right = build(nums, mid+1, end);
        return root;
    }
}
