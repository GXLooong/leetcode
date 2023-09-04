package src;

public class leetcode2 {
    public static void main(String[] args) {
        // 链表：两数相加
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        // 如果有0
        if(l1.val == 0 || l2.val == 0) return l1.val == 0? l2:l1;
        // 遍历
        ListNode ans = new ListNode(-1);
        ListNode pre = ans;
        int carry = 0;
        while(l1 != null || l2 != null){  // 不用&&就可以保证两个list都遍历到底
            int n1 = l1 == null? 0:l1.val;
            int n2 = l2 == null? 0:l2.val;
            int sum = n1 + n2 + carry;
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            carry = sum / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        // 如果还有进位
        if(carry != 0){
            pre.next = new ListNode(carry);
        }
        return ans.next;
    }
}
