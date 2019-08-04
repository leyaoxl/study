package com.leyao.algorithm.offer;

import com.leyao.util.ListNode;

public class q16_合并两个排序的链表 {
    /**
     * 递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = Merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge1(list1, list2.next);
            return list2;
        }
    }

    /**
     * 迭代
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode header = new ListNode(-1);
        ListNode pre = header;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                pre = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                pre = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) pre.next = list1;
        if (list2 != null) pre.next = list2;
        return header.next;
    }
}
