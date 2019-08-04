package com.yaole.problems.sort;

public class ValidAnagram_242 {
    public static boolean isAnagram(String s, String t) {
        /**
         * 分别创建两个新数组，长度为26，保存每个字母出现的次数
         * 对应索引依次为26个字母，出现一次加一
         * 如果两个数组对应位的值相等，就证明两个字符串的字母组成一样
         */
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (char c : s.toCharArray()) sArr[c - 'a']++;
        for (char c : t.toCharArray()) tArr[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (sArr[i] != tArr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
