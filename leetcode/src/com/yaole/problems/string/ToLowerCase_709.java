package com.yaole.problems.string;

public class ToLowerCase_709 {
    public static String toLowerCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "ABSN";
        System.out.println(toLowerCase(str));
    }
}
