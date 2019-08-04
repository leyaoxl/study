package com.yaole.problems.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CustomSortString_791 {
    // public static String customSortString(String S, String T) {
    //     StringBuilder stringBuilder = new StringBuilder();
    //     char[] SArr = S.toCharArray();
    //     char[] TArr = T.toCharArray();
    //     Map<Character, Integer> map = new LinkedHashMap<>();
    //     for (char c : SArr) {
    //         map.put(c, 0);
    //     }
    //     for (char c : TArr) {
    //         if (map.containsKey(c)) {
    //             map.put(c, map.get(c) + 1);
    //         }
    //         else {
    //             map.put(c, 1);
    //         }
    //     }
    //     Set<Map.Entry<Character, Integer>> set = map.entrySet();
    //     for (Map.Entry<Character, Integer> entry : set) {
    //         for (int i = 0; i < entry.getValue(); i++) {
    //             stringBuilder.append(entry.getKey());
    //         }
    //     }
    //     return stringBuilder.toString();
    // }

    public static String customSortString(String S, String T) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] tmpArr = new int[26];
        for (char t : T.toCharArray()) {
            tmpArr[t - 'a']++;
        }
        for (char s : S.toCharArray()) {
            while (tmpArr[s - 'a'] > 0) {
                stringBuilder.append(s);
                tmpArr[s - 'a']--;
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (tmpArr[c - 'a'] > 0) {
                stringBuilder.append(c);
                tmpArr[c - 'a']--;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";
        System.out.println(customSortString(S, T));
    }
}
