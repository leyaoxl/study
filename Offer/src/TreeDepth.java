import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentRootCount = 0;
        int lastRootCount = 1;
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            currentRootCount++;
            if (tmp.left != null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);
            if (currentRootCount == lastRootCount) {
                depth++;
                currentRootCount = 0;
                lastRootCount = queue.size();
            }
        }
        return depth;
    }

    // public int TreeDepth(TreeNode root) {
    //     if (root == null) return 0;
    //     int left = TreeDepth(root.left);
    //     int right = TreeDepth(root.right);
    //     return Math.max(left, right) + 1;
    // }
}
