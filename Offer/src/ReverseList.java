public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
