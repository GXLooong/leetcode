package src;

import java.util.HashMap;
import java.util.Map;

public class leetcode138 {
    public static void main(String[] args) {
        // 复杂链表的深拷贝
    }
    public Node copyRandomList(Node head){
        // 先遍历，并且复制一遍,并记录ListNode向idx的映射(idx从0开始
        int count = 0;
        Map<Node, Integer> node2idx = new HashMap<>();
        Node tmp = head, newDummy = new Node(-1), preNew = newDummy;
        while(tmp != null){
            preNew.next = new Node(tmp.val);
            preNew = preNew.next;
            node2idx.put(tmp, count++);
            tmp = tmp.next;
        }
        // 再遍历，记录旧链表random指向的idx,并记录新链表idx向ListNode的映射
        int[] random = new int[count]; //还得在末尾多存一个null值的idx
        Map<Integer, Node> idx2Node = new HashMap<>();
        tmp = head;
        preNew = newDummy.next;
        int idx = 0;
        while(tmp != null){
            if(tmp.random == null) random[idx] = count;
            else random[idx] = node2idx.get(tmp.random);
            idx2Node.put(idx++, preNew);
            tmp = tmp.next;
            preNew = preNew.next;
        }
        idx2Node.put(count, null);
        // 最后一步: 完善新链表的random指针
        idx = 0;
        preNew = newDummy.next;
        while(preNew != null){
            preNew.random = idx2Node.get(random[idx++]);
            preNew = preNew.next;
        }
        return newDummy.next;
    }
}
