package com.leyao.algorithm.offer;

import com.leyao.util.RandomListNode;

public class q25_复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        cur = pHead;
        while (cur != null) {
            if (cur.random == null) cur.next.random = null;
            else cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode copyHead = cur.next;
        while (cur != null) {
            RandomListNode tmp = cur.next;
            cur.next = tmp.next;
            if (tmp.next == null) tmp.next = null;
            else {
                tmp.next = tmp.next.next;
            }
            cur = cur.next;
        }
        return copyHead;
    }
}
