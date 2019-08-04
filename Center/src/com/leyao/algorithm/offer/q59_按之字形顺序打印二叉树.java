package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class q59_按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        boolean rowMark = false;
        stack1.push(pRoot);
        while (!stack1.empty() || !stack2.empty()) {
            if (!rowMark) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.empty()) {
                    TreeNode tmp = stack1.pop();
                    list.add(tmp.val);
                    if (tmp.left != null) stack2.push(tmp.left);
                    if (tmp.right != null) stack2.push(tmp.right);
                }
                lists.add(list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack2.empty()) {
                    TreeNode tmp = stack2.pop();
                    list.add(tmp.val);
                    if (tmp.right != null) stack1.add(tmp.right);
                    if (tmp.left != null) stack1.add(tmp.left);
                }
                lists.add(list);
            }
            rowMark = !rowMark;
        }
        return lists;
    }
}
