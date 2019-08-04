package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

public class q26_二叉搜索树与双向链表 {
    private TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        helper(pRootOfTree);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    private void helper(TreeNode treeNode) {
        if (treeNode == null) return;
        helper(treeNode.left);

        treeNode.left = pre;
        if (pre != null) pre.right = treeNode;
        pre = treeNode;

        helper(treeNode.right);
    }
}
