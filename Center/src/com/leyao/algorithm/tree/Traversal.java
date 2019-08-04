package com.leyao.algorithm.tree;

import com.leyao.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    /**
     * 二叉树前序遍历
     * 非递归
     * @param treeNode
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        if (treeNode == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.empty()) {
            if (treeNode != null) {
                list.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                TreeNode tmp = stack.pop();
                treeNode = tmp.right;
            }
        }
        return list;
    }

    /**
     * 二叉树前序遍历
     * 递归
     * @param treeNode
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        if (treeNode == null) return list;
        helper1(treeNode, list);
        return list;
    }

    private void helper1(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) return;
        list.add(treeNode.val);
        helper1(treeNode.left, list);
        helper1(treeNode.right, list);
    }

    /**
     * 二叉树中序遍历
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                list.add(tmp.val);
                root = tmp.right;
            }
        }
        return list;
    }

    /**
     * 二叉树中序遍历
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        helper2(root, list);
        return list;
    }

    private void helper2(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) return;
        helper2(treeNode.left, list);
        list.add(treeNode.val);
        helper2(treeNode.right, list);
    }

    /**
     * 二叉树后序遍历
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while (root != null || !stack2.empty()) {
            while (root != null) {
                stack1.push(root);
                stack2.push(root);
                root = root.right;
            }
            if (!stack2.empty()) {
                TreeNode tmp = stack2.pop();
                root = tmp.left;
            }
        }
        while (!stack1.empty()) {
            list.add(stack1.pop().val);
        }
        return list;
    }

    /**
     * 二叉树后序遍历
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        helper3(root, list);
        return list;
    }

    private void helper3(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) return;
        helper3(treeNode.left, list);
        helper3(treeNode.right, list);
        list.add(treeNode.val);
    }
}
