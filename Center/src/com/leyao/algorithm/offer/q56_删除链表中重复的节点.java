package com.leyao.algorithm.offer;

import com.leyao.util.ListNode;

public class q56_删除链表中重复的节点 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode header = new ListNode(-1);
        header.next = pHead;
        ListNode pre = header, cur = pHead;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre.next = cur;
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
        return header.next;
    }
}
