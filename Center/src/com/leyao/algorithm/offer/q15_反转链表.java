package com.leyao.algorithm.offer;

import com.leyao.util.ListNode;

public class q15_反转链表 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode next = null;
        ListNode pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
