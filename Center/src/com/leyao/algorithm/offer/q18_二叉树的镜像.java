package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class q18_二叉树的镜像 {
    /**
     * 递归
     * @param root
     */
    public void Mirror1(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror1(root.left);
        Mirror1(root.right);
    }

    /**
     * 迭代
     * 队列和栈均可
     * @param root
     */
    public void Mirror2(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            TreeNode tmp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmp;
            if (treeNode.left != null) queue.add(treeNode.left);
            if (treeNode.right != null) queue.add(treeNode.right);
        }
    }
}
