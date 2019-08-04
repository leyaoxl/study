package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack2.empty()) {
            while (treeNode != null) {
                stack1.push(treeNode);
                stack2.push(treeNode);
                treeNode = treeNode.right;
            }
            if (!stack2.empty()) {
                TreeNode tmp = stack2.pop();
                treeNode = tmp.left;
            }
        }
        while (!stack1.empty()) {
            list.add(stack1.pop().val);
        }
        return list;
    }
}
