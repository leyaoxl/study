public class Convert {
    private TreeNode preNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        helper(pRootOfTree);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    public void helper(TreeNode cur) {
        if (cur == null) return;

        helper(cur.left);

        cur.left = preNode;
        if (preNode != null) {
            preNode.right = cur;
        }
        preNode = cur;

        helper(cur.right);
    }

}
