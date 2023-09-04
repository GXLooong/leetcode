package src;

public class leetcode24 {
    public static void main(String[] args) {
        // 两两交换链表中的节点
    }
    public ListNode swapPairs(ListNode head){
        // null或者单节点
        if(head == null || head.next == null) return head;
        //
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, tmp = head;
        while(tmp != null && tmp.next != null){
            pre.next = tmp.next;
            tmp.next = tmp.next.next;
            pre.next.next = tmp;
            pre= tmp;
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
