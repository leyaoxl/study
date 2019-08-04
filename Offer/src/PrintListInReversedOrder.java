import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PrintListInReversedOrder {
    // 利用堆栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) return arrayList;
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    // 反转链表
    // public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     if (listNode == null) return list;
    //     ListNode pre = null;
    //     ListNode next = null;
    //     while (listNode != null) {
    //         next = listNode.next;
    //         listNode.next = pre;
    //         pre = listNode;
    //         listNode = next;
    //     }
    //     while (pre != null) {
    //         list.add(pre.val);
    //         pre = pre.next;
    //     }
    //     return list;
    // }
}
