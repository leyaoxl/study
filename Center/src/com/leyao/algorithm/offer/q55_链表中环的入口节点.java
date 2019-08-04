package com.leyao.algorithm.offer;

import com.leyao.util.ListNode;

public class q55_链表中环的入口节点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) return null;
        ListNode cur = pHead;
        ListNode slow = cur.next, fast = cur.next.next;
        while (slow != fast) {
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else return null;
        }
        fast = cur;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
