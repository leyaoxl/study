package com.yaole.problems.tree;

import java.util.ArrayList;
import java.util.List;

public class N_aryTreePreorderTraversal_589 {
    private class Node {
        int val;
        List<Node> children;

        public Node() {

        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        return preorder(root, list);
    }

    private List<Integer> preorder(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) {
                preorder(node, list);
            }
        }
        return list;
    }
}
