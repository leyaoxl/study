package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.empty()) {
            if (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                TreeNode tmpNode = stack.pop();
                list.add(tmpNode.val);
                tmp = tmpNode.right;
            }
        }
        return list;
    }
}
