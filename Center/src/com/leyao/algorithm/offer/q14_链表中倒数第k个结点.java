package com.leyao.algorithm.offer;

import com.leyao.util.ListNode;

public class q14_链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode tmp = head;
        while (k > 0) {
            if (tmp == null) return null;
            tmp = tmp.next;
            k--;
        }
        while (tmp != null) {
            tmp = tmp.next;
            head = head.next;
        }
        return head;
    }
}
