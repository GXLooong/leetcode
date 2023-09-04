package src;

public class leetcode206 {
    public static void main(String[] args) {

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
    /*
    迭代方法
    public static ListNode reverseList(ListNode head) {
        // 两个指针不够就三指针
        if(head == null || head.next == null) return head;
        ListNode pre = null, cur = head, next = head.next;
        while(cur != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            if(next != null){
                next = cur.next;
            }
        }
        return pre;
    }*/
}

