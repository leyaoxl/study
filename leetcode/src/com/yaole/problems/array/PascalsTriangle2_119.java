package com.yaole.problems.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2_119 {
    public static void main(String[] args) {
        System.out.println(getRow(4));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        result.add(1);
        if (rowIndex == 1) {
            return result;
        }
        for (int i = 2; i <= rowIndex; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}
