package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

public class q4_重建二叉树 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null) return null;
        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode helper(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (endPre < startPre || endIn < startIn) return null;
        int head = pre[startPre];
        TreeNode root = new TreeNode(head);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == head) {
                root.left = helper(pre, startPre + 1, startPre - startIn + i, in, startIn, i - 1);
                root.right = helper(pre, startPre - startIn + i + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
}
