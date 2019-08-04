package com.leyao.algorithm.offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class q34_第一次只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        char tmp = '1';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                tmp = entry.getKey();
                break;
            }
        }
        if (tmp == '1') return -1;
        return str.indexOf(tmp);
    }
}
