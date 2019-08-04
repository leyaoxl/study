package com.yaole.problems.string;

public class ReverseWordsInAStringIII_557 {
    public static String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strArr) {
            if (str.length() > 1) {
                char[] chars = str.toCharArray();
                for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
                stringBuilder.append(new String(chars));
            }
            else stringBuilder.append(str);
            stringBuilder.append(" ");
        }
        String result = stringBuilder.toString();
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        String s = "I love u";
        System.out.println(reverseWords(s));
    }
}
