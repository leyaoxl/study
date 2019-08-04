public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode cur = pHead;
        ListNode pre = first;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                pre.next = cur;
            }
        }
        return first.next;
    }
}
