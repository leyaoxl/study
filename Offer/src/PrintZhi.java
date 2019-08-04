import java.util.ArrayList;
import java.util.Stack;

public class PrintZhi {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int row = 1;
        stack1.push(pRoot);
        while (!stack1.empty() || !stack2.empty()) {
            if (row % 2 == 1) {
                ArrayList<Integer> tmpList = new ArrayList<>();
                while (!stack1.empty()) {
                    TreeNode treeNode = stack1.pop();
                    tmpList.add(treeNode.val);
                    if (treeNode.left != null) stack2.push(treeNode.left);
                    if (treeNode.right != null) stack2.push(treeNode.right);
                }
                result.add(tmpList);
                row++;
            } else {
                ArrayList<Integer> tmpList = new ArrayList<>();
                while (!stack2.empty()) {
                    TreeNode treeNode = stack2.pop();
                    tmpList.add(treeNode.val);
                    if (treeNode.right != null) stack1.push(treeNode.right);
                    if (treeNode.left != null) stack1.push(treeNode.left);
                }
                result.add(tmpList);
                row++;
            }
        }
        return result;
    }
}
