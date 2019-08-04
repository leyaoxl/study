package com.yaole.problems.string;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class CountAndSay_38 {
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        else  {
            String s = countAndSay(n - 1);
            StringBuilder stringBuilder = new StringBuilder();
            char[] cArr = s.toCharArray();
            int num = 0, j = 0;
            for (int i = 0; i < cArr.length; i++) {
                if (cArr[i] == cArr[j]) num++;
                else {
                    stringBuilder.append(num);
                    stringBuilder.append(cArr[j]);
                    num = 1;
                    j = i;
                }
            }
            stringBuilder.append(num);
            stringBuilder.append(cArr[cArr.length - 1]);
            return stringBuilder.toString();
        }

    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
