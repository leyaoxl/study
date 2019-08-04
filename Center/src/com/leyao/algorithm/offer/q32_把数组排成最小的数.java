package com.leyao.algorithm.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class q32_把数组排成最小的数 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null) return null;
        if (numbers.length == 0) return "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : numbers) list.add(i);
        Collections.sort(list, (a, b) -> {
            String s1 = "" + a + b;
            String s2 = "" + b + a;
            return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : list) stringBuilder.append(num);
        return stringBuilder.toString();
    }
}
