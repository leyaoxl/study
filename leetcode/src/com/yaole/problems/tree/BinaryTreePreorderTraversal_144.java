package com.yaole.problems.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }

    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     list = helper(root, list);
    //     return list;
    // }
    //
    // private List<Integer> helper(TreeNode treeNode, List<Integer> list) {
    //     if (treeNode != null) {
    //         list.add(treeNode.val);
    //         helper(treeNode.left, list);
    //         helper(treeNode.right, list);
    //     }
    //     return list;
    // }
}
