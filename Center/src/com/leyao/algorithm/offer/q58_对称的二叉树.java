package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class q58_对称的二叉树 {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot.left);
        queue.add(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
