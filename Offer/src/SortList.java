public class SortList {
    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode listNode = slow.next;
        slow.next = null;
        ListNode node1 = sort(head);
        ListNode node2 = sort(listNode);
        return merge(node1, node2);
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode header = new ListNode(-1);
        ListNode pre = header;
        ListNode start1 = node1;
        ListNode start2 = node2;
        while (start1 != null && start2 != null) {
            if (start1.val <= start2.val) {
                pre.next = start1;
                pre = start1;
                start1 = start1.next;
            } else {
                pre.next = start2;
                pre = start2;
                start2 = start2.next;
            }
        }
        while (start1 != null) {
            pre.next = start1;
            pre = start1;
            start1 = start1.next;
        }
        while (start2 != null) {
            pre.next = start2;
            pre = start2;
            start2 = start2.next;
        }
        return header.next;
    }
}
