package com.leyao.algorithm.offer;

public class q44_翻转单词顺序列 {
    // 直接进行字符验证拼装
    public String ReverseSentence(String str) {
        if (str == null) return null;
        if (str.length() == 0) return "";
        String s = "";
        String tmp = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') tmp += str.charAt(i);
            else {
                s = " " + tmp + s;
                tmp = "";
            }
        }
        s = tmp + s;
        return s;
    }
}
