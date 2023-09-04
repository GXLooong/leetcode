package src;

import java.util.ArrayList;
import java.util.List;

public class leetcode160 {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode a=headA, b=headB;
        while(!(a==null && b==null)){
            if(a == b){
                return a;
            }
            a = a==null? headB:a.next;
            b = b==null? headA:b.next;

        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode build(int[] nums){
        if(nums.length == 0) return null;
        int n = nums.length;
        ListNode dummy = new ListNode(-1), pre = dummy;
        for (int i = 0; i < n; i++) {
            pre.next = new ListNode(nums[i]);
            pre = pre.next;
        }
        return dummy.next;
    }

    public static void print(ListNode head){
        if(head == null){
            System.out.println("输入的head为空");
        }
        List<Integer> nums = new ArrayList<>();
        while(head != null){
            nums.add(head.val);
            head = head.next;
        }
        System.out.println(nums);
    }

}