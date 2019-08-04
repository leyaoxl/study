package com.yaole.problems.string;

public class DetectCapital_520 {
    public static boolean detectCapitalUse(String word) {
        if (word.equals(word.toLowerCase())
                || word.equals(word.toUpperCase())
                || (word.substring(0, 1).equals(word.substring(0, 1).toUpperCase()) && word.substring(1, word.length()).equals(word.substring(1, word.length()).toLowerCase()))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String word = "g";
        System.out.println(detectCapitalUse(word));
    }
}
