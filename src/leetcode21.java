package src;

public class leetcode21 {
    public static void main(String[] args) {
        // 合并两个有序链表
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        // 创建头节点,存放-1,就可以省去专门处理头节点的麻烦，最后返回ans.next就好了！
        ListNode ans = new ListNode(-1);
        // 遍历，比较；
        ListNode tmp = ans;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        // 拼接还没遍历到的
        if(l1 == null){
            tmp.next = l2;
        }else{
            tmp.next = l1;
        }
        return ans.next;
    }
}
