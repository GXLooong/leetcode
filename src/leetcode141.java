package src;

public class leetcode141 {
    public static void main(String[] args) {
        // 环形链表
    }

    public boolean hasCycle(ListNode head) {
        // 方法一： hash方法，时间和空间复杂度都是O(n)
        /*Set<ListNode> visited = new HashSet<>();
        while(head != null){
            if(!visited.add(head)) return true;
            else{
                head = head.next;
            }
        }
        return false;*/

        // 方法二：快慢指针法
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
