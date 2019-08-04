package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

public class q17_树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        boolean result = false;
        if (root1.val == root2.val) {
            result = helper(root1, root2);
        }
        if (!result) result = HasSubtree(root1.left, root2);
        if (!result) result = HasSubtree(root1.right, root2);
        return result;
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }
}
