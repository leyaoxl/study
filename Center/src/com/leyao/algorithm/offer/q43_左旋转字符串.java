package com.leyao.algorithm.offer;

public class q43_左旋转字符串 {
    public String LeftRotateString(String str,int n) {
        if (str == null) return null;
        if (str.length() == 0) return "";
        n %= str.length();
        String s1 = str.substring(0, n);
        String s2 = str.substring(n, str.length());
        return s2 + s1;
    }
}
