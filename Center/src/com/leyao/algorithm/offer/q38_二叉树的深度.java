package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class q38_二叉树的深度 {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int deep = 0;
        int curNodeNums = 0;
        int rowNodeSum = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            curNodeNums++;
            if (tmp.left != null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);
            if (curNodeNums == rowNodeSum) {
                deep++;
                curNodeNums = 0;
                rowNodeSum = queue.size();
            }
        }
        return deep;
    }
}
