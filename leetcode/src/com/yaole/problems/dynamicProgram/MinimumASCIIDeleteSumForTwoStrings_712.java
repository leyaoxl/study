package com.yaole.problems.dynamicProgram;

public class MinimumASCIIDeleteSumForTwoStrings_712 {
    public int minimumDeleteSum(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int sum = 0;
        for (char c : chars1) sum += c;
        for (char c : chars2) sum += c;
        int index = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (s2.in)
        }

        return sum;
    }

    public static void main(String[] args) {
        MinimumASCIIDeleteSumForTwoStrings_712 minimumASCIIDeleteSumForTwoStrings_712 = new MinimumASCIIDeleteSumForTwoStrings_712();
        System.out.println(minimumASCIIDeleteSumForTwoStrings_712.minimumDeleteSum("abc", "bcd"));
    }
}
