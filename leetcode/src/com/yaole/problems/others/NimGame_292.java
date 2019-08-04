package com.yaole.problems.others;

public class NimGame_292 {
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println(canWinNim(4));
    }
}
