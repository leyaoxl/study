package com.yaole.problems.string;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses_22 {
    public static List<String> generateParenthesis(int n) {
        List<String> resultList = new LinkedList<>();
        generate(resultList, "", 0, 0, n);
        return resultList;
    }

    private static void generate(List<String> resultList, String s, int leftCount, int rightCount, int n) {
        if (leftCount > n || rightCount > n) return;
        if (leftCount == n && rightCount == n) resultList.add(s);
        if (leftCount >= rightCount) {
            generate(resultList, s + "(", leftCount + 1, rightCount, n);
            generate(resultList, s + ")", leftCount, rightCount + 1, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
