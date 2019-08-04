public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) return null;
        ListNode tmp = head;
        ListNode result = head;
        int i = 0;
        while (tmp != null) {
            if (i < k) {
                tmp = tmp.next;
                i++;
            } else {
                tmp = tmp.next;
                result = result.next;
                i++;
            }
        }
        if (k > i) return null;
        return result;
    }
}