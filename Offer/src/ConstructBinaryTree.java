class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
        this.val = val;
    }
}

public class ConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode treeNode = helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return treeNode;
    }

    public TreeNode helper(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (endPre < startPre || endIn < startIn) return null;
        TreeNode treeNode = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                treeNode.left = helper(pre, startPre + 1, startPre - startIn + i, in, startIn, i - 1);
                treeNode.right = helper(pre, startPre - startIn + i + 1, endPre, in, i + 1, endIn);
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        System.out.println(constructBinaryTree.reConstructBinaryTree(pre, in));
    }
}
