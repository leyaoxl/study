public class P_序列化二叉树 {
    public String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append("#,");
            return stringBuilder.toString();
        }
        stringBuilder.append(root.val);
        stringBuilder.append(",");
        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(Serialize(root.right));
        return stringBuilder.toString();
    }

    private int index = -1;

    public TreeNode Deserialize(String str) {
        index++;
        if (index >= str.length()) return null;
        String[] strings = str.split(",");
        TreeNode treeNode = null;
        if (!strings[index].equals("#")) {
            treeNode = new TreeNode(0);
            treeNode.val = Integer.valueOf(strings[index]);
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }
}
