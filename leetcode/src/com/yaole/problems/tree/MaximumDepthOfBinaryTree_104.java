package com.yaole.problems.tree;

public class MaximumDepthOfBinaryTree_104 {
    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + (left > right ? left : right);
    }
}
