import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsSymmetrical {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot.left);
        queue.add(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null) return false;
            if (leftNode.val != rightNode.val) return false;
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }
        return true;
    }
}
