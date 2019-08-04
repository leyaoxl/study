package com.leyao.algorithm.offer;

import com.leyao.util.TreeLinkNode;

public class q57_二叉树的下一个节点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        TreeLinkNode cur = pNode;
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) cur = cur.left;
            return cur;
        }
        cur = pNode;
        while (cur.next != null) {
            if (cur.next.left == cur) return cur.next;
            cur = cur.next;
        }
        return null;
    }
}
