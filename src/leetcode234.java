package src;

import java.util.List;

public class leetcode234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3, new ListNode(4, new ListNode(5, null)));
        int len = countLen(head);
        System.out.println(len);
        System.out.println(head.val);
    }

    public static boolean isPalindrome(ListNode head) {
        int len = countLen(head);
        if(len == 0 || len == 1){
            return true;
        }
        int num = 0;
        ListNode midHead = head;
//        while(num > 0){
//
//        }
        return true;
    }

    public static int countLen(ListNode head){
        int len = 0;
        //ListNode tmp = head;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    public static ListNode reverseList(ListNode head) {
        /*
         * 使用递归方法需要意识到，在java中，修改完链表的指针是不需要返回的，在过程中的修改已经自动保存了
         * 只返回末尾节点就可以了
         * */
        // 递归方法
        //返回条件
        if(head == null || head.next == null) return head;
        //先排后面的,head.next = null必须放在后面
        ListNode newHead = reverseList(head.next);
        //
        head.next.next = head;
        head.next = null;
        return newHead;
    }



}
