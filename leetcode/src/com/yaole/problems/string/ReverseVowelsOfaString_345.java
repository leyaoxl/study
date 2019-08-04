package com.yaole.problems.string;

import java.util.Arrays;

public class ReverseVowelsOfaString_345 {
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        char tmp = 'a';
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i] != 'a' && chars[i] != 'e' && chars[i] != 'i' && chars[i] != 'o' && chars[i] != 'u' && chars[i] != 'A' && chars[i] != 'E' && chars[i] != 'I' && chars[i] != 'O' && chars[i] != 'U') {
                i++;
            }
            else if (chars[j] != 'a' && chars[j] != 'e' && chars[j] != 'i' && chars[j] != 'o' && chars[j] != 'u' && chars[j] != 'A' && chars[j] != 'E' && chars[j] != 'I' && chars[j] != 'O' && chars[j] != 'U') {
                j--;
            }
            else {
                tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}
