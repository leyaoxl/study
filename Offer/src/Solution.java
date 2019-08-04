import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String tmpStr = s.trim();
        if (tmpStr == "" || tmpStr.length() == 0) {
            System.out.println("True");
        } else if (s.equals("None")) {
            System.out.println("True");
        } else {
            String[] strArr = s.split(",");
            int len = strArr.length;
            int[] vals = new int[len];
            for (int i = 0; i < len; i++) {
                vals[i] = Integer.parseInt(strArr[i]);
            }
            TreeNode root = buildBSTTree(vals);
            boolean flag = isValidBST(root);
            if (flag) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
    public static TreeNode buildBSTTree(int[] vals) {
        if (vals.length == 0) {
            return null;
        }
        int length = vals.length;

        ArrayList<TreeNode> tmpList = new ArrayList<TreeNode>(length);
        for (int i = 0; i < length; i++) {
            TreeNode node = new TreeNode(vals[i]);
            tmpList.add(node);
        }

        for (int i = 0; i < length / 2 - 1; i++) {
            TreeNode node = tmpList.get(i);
            node.left = tmpList.get(2 * i + 1);
            node.right = tmpList.get(2 * i + 2);
        }

        int lastNode = length / 2 - 1;
        TreeNode node = tmpList.get(lastNode);

        node.left = tmpList.get(lastNode * 2 + 1);

        if (length % 2 != 0) {
            node.right = tmpList.get(lastNode * 2 + 2);
        }

        TreeNode root = tmpList.get(0);
        tmpList.clear();
        return root;

    }
    public static  boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Integer last = null;
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left != null) {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    if (last != null && cur.val <= last) return false;
                    last = cur.val;
                    cur = cur.right;
                }
            } else {
                if (last != null && cur.val <= last) return false;
                last = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }
}