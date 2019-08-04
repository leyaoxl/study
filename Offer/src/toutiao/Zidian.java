package toutiao;

import java.util.HashSet;

public class Zidian {
    public static boolean strSearch(String[] arr, String str) {
        HashSet<String> set = new HashSet<>();
        for (String s : arr) set.add(s);
        String[] tmpArr = str.split(" ");
        for (String s : tmpArr) {
            if (!set.contains(s)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr = {"i", "have", "a", "book", "good"};
        String str = "i have a book";
        Zidian zidian = new Zidian();
        System.out.println(zidian.strSearch(arr, str));
    }
}
