package com.yaole.problems.string;

public class RotatedDigits_788 {
    public static int rotatedDigits(int N) {
        int result = 0;
        lala:
        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            boolean b = false;
            for (char c : s.toCharArray()) {
                if (c != '0' && c != '1' && c != '8'
                        && c != '2' && c != '5' && c != '6' && c != '9')
                    continue lala;
                if (c == '2' || c == '5' || c == '6' || c == '9')
                    b = true;
            }
            if (b) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 857;
        System.out.println(rotatedDigits(n));
    }
}
