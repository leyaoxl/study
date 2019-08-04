package com.leyao.algorithm.offer;

import com.leyao.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class q60_把二叉树打印成多行 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(pRoot);
        int cur = 0;
        int sum = 1;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            cur++;
            list.add(tmp.val);
            if (tmp.left != null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);
            if (cur == sum) {
                cur = 0;
                sum = queue.size();
                lists.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return lists;
    }
}
