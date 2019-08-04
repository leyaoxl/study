package com.yaole.problems.string;

public class IntegerToRoman_12 {
    // public String intToRoman(int num) {
    //     String s = String.valueOf(num);
    //     char[] chars = s.toCharArray();
    //     int length = chars.length;
    //     StringBuilder stringBuilder = new StringBuilder();
    //     for (int i = 0; i < length; i++) {
    //         int n = chars[i] - '0';
    //         int level = length - i;
    //         stringBuilder.append(general(n, level));
    //     }
    //     return stringBuilder.toString();
    // }
    //
    // private String general(int n, int level) {
    //     StringBuilder stringBuilder = new StringBuilder();
    //     String one = "", four = "", five = "", nine = "";
    //     switch (level) {
    //         case 4: {
    //             one = "M";
    //             while (n > 0) {
    //                 stringBuilder.append(one);
    //                 n--;
    //             }
    //             return stringBuilder.toString();
    //         }
    //         case 3: {
    //             one = "C";
    //             four = "CD";
    //             five = "D";
    //             nine = "CM";
    //             break;
    //         }
    //         case 2: {
    //             one = "X";
    //             four = "XL";
    //             five = "L";
    //             nine = "XC";
    //             break;
    //         }
    //         case 1: {
    //             one = "I";
    //             four = "IV";
    //             five = "V";
    //             nine = "IX";
    //             break;
    //         }
    //     }
    //
    //     if (n == 4) {
    //         stringBuilder.append(four);
    //     } else if (n == 5) {
    //         stringBuilder.append(five);
    //     } else if (n == 9) {
    //         stringBuilder.append(nine);
    //     } else if (n < 5) {
    //         while (n > 0) {
    //             stringBuilder.append(one);
    //             n--;
    //         }
    //     } else {
    //         stringBuilder.append(five);
    //         while (n > 5) {
    //             stringBuilder.append(one);
    //             n--;
    //         }
    //     }
    //     return stringBuilder.toString();
    // }

    final static int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    final static String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while ((num - nums[i]) >= 0) {
                stringBuilder.append(strings[i]);
                num = num - nums[i];
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
