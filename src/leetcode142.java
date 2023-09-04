package src;

import java.util.HashSet;
import java.util.Set;

public class leetcode142 {
    public static void main(String[] args) {
        // 环形链表 Ⅱ

    }
    public ListNode detectCycle(ListNode head){
        // 快慢指针 + 数学推理
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode index1 = slow;
                ListNode index2 = head;
                while(index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
