package com.leyao.algorithm.offer;

public class q49_把字符串转换成整数 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        boolean mark = true;
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && chars[i] == '+') continue;
            if (i == 0 && chars[i] == '-') {
                mark = false;
                continue;
            }
            if (chars[i] < '0' || chars[i] > '9') return 0;
            sum = sum * 10 + (chars[i] - '0');
        }
        if (mark) return sum;
        return -sum;
    }
}
