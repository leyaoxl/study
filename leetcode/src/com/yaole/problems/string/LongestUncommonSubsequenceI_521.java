package com.yaole.problems.string;

public class LongestUncommonSubsequenceI_521 {
    public static int findLUSlength(String a, String b) {
        if (a.length() != b.length())
            return a.length() < b.length() ? b.length() : a.length();
        if (a.equals(b)) return -1;
        return a.length();
    }

    public static void main(String[] args) {
        String a = "aba", b = "cdc";
        System.out.println(findLUSlength(a, b));
    }
}
