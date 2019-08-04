import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        ArrayList<Integer> tmpList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int rowNum = 0, nodeNum = 1;
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            if (tmpNode.left != null) queue.add(tmpNode.left);
            if (tmpNode.right != null) queue.add(tmpNode.right);
            tmpList.add(tmpNode.val);
            rowNum++;
            if (rowNum == nodeNum) {
                result.add(tmpList);
                tmpList = new ArrayList<>();
                rowNum = 0;
                nodeNum = queue.size();
            }
        }
        return result;
    }
}
