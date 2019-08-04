package com.yaole.problems.array;

public class oneBitAndTwoBitCharacters_717 {
    public static void main(String[] args) {
        int[] bits = new int[] {0, 1, 1, 0};
        System.out.println(isOneBitCharacter(bits));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 0 || bits == null) {
            return false;
        }

        int i = 0;

        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i+=1;
            }
            else {
                i+=2;
            }
        }

        if (i == bits.length - 1) {
            return true;
        }

        return false;
    }
}
