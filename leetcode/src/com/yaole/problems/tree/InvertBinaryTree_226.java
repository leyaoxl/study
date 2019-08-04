package com.yaole.problems.tree;

public class InvertBinaryTree_226 {
    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode result = new TreeNode(root.val);
        result.left = invertTree(root.right);
        result.right = invertTree(root.left);
        return result;
    }
}
