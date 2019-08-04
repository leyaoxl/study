package com.yaole.problems.string;

public class ReverseString_344 {
    public static String reverseString(String s) {
        if (s.length() == 1) return s;
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(reverseString(s));
        System.out.println("amanaP :lanac a ,nalp a ,nam A");
    }
}
