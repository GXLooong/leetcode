package src;

public class leetcode19 {
    public static void main(String[] args) {
        // 删除链表的第N个节点

    }

    public ListNode removeNthFromEnd(ListNode head, int n){
        // 设置头节点,防止只有一个节点的情况（到不了该节点的上一个节点）
        ListNode dummy = new ListNode(-1, head);
        int uesless = deleteNth(dummy, n);
        return dummy.next;
    }

    static int deleteNth(ListNode node, int k){
        if(node == null) return 0;
        int depth = deleteNth(node.next, k) + 1;
        if(depth == k+1){
            node.next = node.next.next;
        }
        return depth;
    }
}
