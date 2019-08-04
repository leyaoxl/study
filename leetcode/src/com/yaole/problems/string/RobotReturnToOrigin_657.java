package com.yaole.problems.string;

public class RobotReturnToOrigin_657 {
    public static boolean judgeCircle(String moves) {
        if (moves == null) return true;
        int resultNum1 = 0;
        int resultNum2 = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    resultNum1++;
                    break;
                case 'U':
                    resultNum2++;
                    break;
                case 'L':
                    resultNum1--;
                    break;
                case 'D':
                    resultNum2--;
                    break;
            }
        }
        return resultNum1 == 0 && resultNum2 == 0;
    }

    public static void main(String[] args) {
        String moves = "RRDD";
        System.out.println(judgeCircle(moves));
    }
}
