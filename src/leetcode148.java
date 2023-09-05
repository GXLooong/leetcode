package src;

public class leetcode148 {
    public static void main(String[] args) {
        // 给链表排序
        ListNode head = ListNode.build(new int[]{4, 2, 1, 3});
        ListNode newHead = sortList(head);
    }
    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // 利用快慢指针也可以完成归并排序
        return sortList(head, null);  //左闭右开省去了一次遍历找队尾的时间
    }

    public static  ListNode sortList(ListNode head, ListNode tail){
        // 返回条件
        if(head.next == tail){
            head.next = null;  // 左闭右开，不包括tail
            return head;
        }

        // 利用快慢指针来找出mid
        ListNode fast = head, slow = head, mid = null;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){  //因为长度不一定是奇或者偶
                fast = fast.next;
            }
        }
        mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1, list2);
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 != null){
            pre.next = l1;
        }else{
            pre.next = l2;
        }
        return dummy.next;
    }

    /*public static ListNode sortList(ListNode head){
        if(head == null || head.next == null) return head;
        @SuppressWarnings("all")
        // 冒泡排序
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode pre = dummy, cur = head, next = cur.next, end = null;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        for (int i = 0; i < count; i++) {
            pre = dummy;
            cur = dummy.next;
            next = cur.next;
            while(cur.next != end){
                next = cur.next;
                if(cur.val > next.val){
                    cur.next = next.next;
                    pre.next = next;
                    next.next = cur;
                    pre = next;
                }else{
                    pre = cur;
                    cur = next;
                }
            }
            end = cur;
        }
        return dummy.next;
    }*/
}
