package com.leyao.algorithm.offer;

public class q2_替换空格 {
    public String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}
