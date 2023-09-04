package src;

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
}