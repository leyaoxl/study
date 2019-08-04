import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Mirror {
    // 非递归
    // public void Mirror(TreeNode root) {
    //     if (root == null) return;
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //     while (!stack.empty()) {
    //         TreeNode treeNode = stack.pop();
    //         TreeNode tmp = treeNode.left;
    //         treeNode.left = treeNode.right;
    //         treeNode.right = tmp;
    //         if (treeNode.left != null) stack.push(treeNode.left);
    //         if (treeNode.right != null) stack.push(treeNode.right);
    //     }
    // }

    // // 递归
    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
