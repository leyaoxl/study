import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) return result;
        char[] chars = str.toCharArray();
        helper(chars, 0, result);
        Collections.sort(result);
        return result;
    }

    private void helper(char[] chars, int index, ArrayList<String> list) {
        if (index == chars.length - 1) {
            String s = String.valueOf(chars);
            if (!list.contains(s)) list.add(s);
        } else {
            for (int i = index; i < chars.length; i++) {
                swap(chars, index, i);
                helper(chars, index + 1, list);
                swap(chars, index, i);
            }
        }
    }

    private void swap(char[] chars, int x, int y) {
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.Permutation("abc"));
    }
}
