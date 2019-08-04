import java.util.ArrayList;

public class FindPath {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return result;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return result;
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return result;
    }
}
