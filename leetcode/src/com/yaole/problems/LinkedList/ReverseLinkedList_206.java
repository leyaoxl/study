package com.yaole.problems.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}

public class ReverseLinkedList_206 {
    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null; // 前一个结点
        ListNode now = head; // 当前结点
        ListNode suf = null; // 链表反转后的头结点
        while (now != null) {
            ListNode next = now.next; // 将下一个结点保存起来
            if (next == null) suf = now;
            now.next = pre; // 将当前结点的指针指向前一结点，完成反转操作
            pre = now; // 将当前结点作为下一个结点的前一节点
            now = next; // 将当前结点更新为下一个结点
        }
        return suf;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head; // 当前结点为null或者下一结点为null直接返回
        ListNode next = head.next; // 保存下一结点
        head.next = null; // 将当前结点的指针置为null
        ListNode reverseHead = reverseList(next); // 利用递归确定最终反转链表的头结点
        next.next = head; // 对所有结点指针进行反转
        return reverseHead; // 返回反转之后的头结点
    }
}
