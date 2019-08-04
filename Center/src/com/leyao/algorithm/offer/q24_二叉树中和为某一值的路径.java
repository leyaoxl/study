package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

import java.util.ArrayList;

public class q24_二叉树中和为某一值的路径 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, target, lists, list);
        return lists;
    }

    private void helper(TreeNode root, int target, ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        helper(root.left, target, lists, list);
        helper(root.right, target, lists, list);
        list.remove(list.size() - 1);
    }
}