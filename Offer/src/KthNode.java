import java.util.Stack;

public class KthNode {
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) return null;
        int index = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = null;
        while (pRoot != null || !stack.empty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            TreeNode tmp = stack.pop();
            index++;
            if (index == k) result = tmp;
            pRoot = tmp.right;
        }
        return result;
    }

    // private int index = 0;
    //
    // public TreeNode KthNode(TreeNode pRoot, int k) {
    //     if (pRoot != null) {
    //         TreeNode node = KthNode(pRoot.left, k);
    //         if (node != null) return node;
    //         index++;
    //         if (index == k) return pRoot;
    //         node = KthNode(pRoot.right, k);
    //         if (node != null) return node;
    //     }
    //     return null;
    // }
}
