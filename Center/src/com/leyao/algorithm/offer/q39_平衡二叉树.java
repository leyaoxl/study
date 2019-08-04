package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

public class q39_平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int num = helper(root);
        if (num == -1) return false;
        return true;
    }

    private int helper(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int left = helper(treeNode.left);
        if (left == -1) return -1;
        int right = helper(treeNode.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
