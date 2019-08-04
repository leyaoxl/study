package com.leyao.algorithm.offer;

public class q53_表示数值的字符串 {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        String s = String.valueOf(str);
        return s.matches("[+-]?[0-9]*(\\.[0-9]+)?([eE][+-]?[0-9]+)?");
    }
}
