package com.leyao.algorithm.offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class q27_字符串的排列 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) return list;
        char[] chars = str.toCharArray();
        helper(chars, 0, list);
        Collections.sort(list);
        return list;
    }

    private void helper(char[] chars, int index, ArrayList<String> list) {
        if (index == chars.length - 1) {
            String s = String.valueOf(chars);
            if (!list.contains(s)) list.add(s);
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            helper(chars, index + 1, list);
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
}
