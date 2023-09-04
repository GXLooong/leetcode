package src;

public class leetcode25 {
    public static void main(String[] args) {
        // K个一组反转链表
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4});
        ListNode newHead = reverseKGroup(head, 2);
        ListNode.print(newHead);
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        // 只有一个结点
        if(head.next == null) return head;

        // 五个指针,配合count遍历
        int count = k;
        ListNode dummy = new ListNode(-1, head); // 后接不是head也没关系
        ListNode pre = null, cur = head, next = head.next, tail1 = dummy, tail2 = head;  // tail1表示上一个片段的尾，tail2
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count --;
            if(count == 0){
                // 并没有对pre和cur做出改变，所以外面的操作还是不用变的。
                tail1.next = pre;
                tail1 = tail2;
                tail2 = cur;
                count = k;
            }
        }
        // 反转最后不应被反转的那一部分，上面的while结束的时候，pre指向这个小尾巴的头，tail2指向这个尾,tail1指向上一个片段的尾巴
        if(count != k){
            tail1.next = tail2;
            cur = pre;
            pre = null;
            while(pre != tail2){  // 到tail2中止，而不是到null中止
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

        }else{
            tail1.next = null;
        }
        return dummy.next;
    }
}
