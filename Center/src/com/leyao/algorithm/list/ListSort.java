package com.leyao.algorithm.list;

import com.leyao.util.ListNode;

public class ListSort {
    /**
     * 单链表排序
     * 归并法
     * @param listNode
     * @return
     */
    public ListNode sortList(ListNode listNode) {
        if (listNode == null || listNode.next == null) return listNode;
        ListNode cur = listNode;
        ListNode slow = cur, fast = cur.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(cur);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode header = new ListNode(-1);
        ListNode pre = header;
        while (left != null && right != null) {
            if (left.val < right.val) {
                pre.next = left;
                pre = left;
                left = left.next;
            } else {
                pre.next = right;
                pre = right;
                right = right.next;
            }
        }
        if (left != null) pre.next = left;
        if (right != null) pre.next = right;
        return header.next;
    }
}
