package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

import java.util.Stack;

public class q62_二叉搜索树的第k个结点 {
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = null;
        while (pRoot != null || !stack.empty()) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                TreeNode tmp = stack.pop();
                k--;
                if (k == 0) {
                    result = tmp;
                    break;
                }
                pRoot = tmp.right;
            }
        }
        return result;
    }
}
