package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode treeNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (treeNode == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = treeNode;
        while (tmp != null || !stack.empty()) {
            if (tmp != null) {
                stack.push(tmp);
                list.add(tmp.val);
                tmp = tmp.left;
            } else {
                TreeNode tmpNode = stack.pop();
                tmp = tmpNode.right;
            }
        }
        return list;
    }
}
