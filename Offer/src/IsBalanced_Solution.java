public class IsBalanced_Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (helper(root) == -1) return false;
        return true;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        if (left == -1) return -1;
        int right = helper(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

    // public boolean IsBalanced_Solution(TreeNode root) {
    //     if (root == null) return true;
    //
    //     if (Math.abs(helper(root.left) - helper(root.right)) > 1) return false;
    //
    //     return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    // }
    //
    // private int helper(TreeNode treeNode) {
    //     if (treeNode == null) return 0;
    //     int deepLeft = helper(treeNode.left);
    //     int deepRight = helper(treeNode.right);
    //     return Math.max(deepLeft, deepRight) + 1;
    // }
}
