package com.yaole.problems.tree;

import java.util.ArrayList;
import java.util.List;

public class N_aryTreePostorderTraversal_590 {
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

    public List<Integer> postorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        return postorder(root, list);
    }

    private List<Integer> postorder(Node root, List<Integer> list) {
        if (root != null) {
            for (Node node : root.children) {
                postorder(node, list);
            }
            list.add(root.val);
        }
        return list;
    }
}
