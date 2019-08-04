package com.leyao.algorithm.offer;

import com.leyao.util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class q3_从尾到头打印链表 {
    // 利用栈
    public ArrayList<Integer> print1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) return list;
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop().val);
        }
        return list;
    }

    // 反转链表
    public ArrayList<Integer> print2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) return list;
        ListNode cur = listNode;
        ListNode next = null;
        ListNode pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while (pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }
}
