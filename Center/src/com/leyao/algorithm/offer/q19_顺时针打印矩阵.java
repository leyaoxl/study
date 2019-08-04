package com.leyao.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;

public class q19_顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int m = matrix.length, n = matrix[0].length;
        int x1 = 0, x2 = m - 1, y1 = 0, y2 = n - 1;
        while (x1 <= x2 && y1 <= y2) {
            for (int i = y1; i <= y2; i++) {
                list.add(matrix[x1][i]);
            }
            for (int i = x1 + 1; i <= x2; i++) {
                list.add(matrix[i][y2]);
            }
            if (x1 != x2) {
                for (int i = y2 - 1; i >= y1; i--) {
                    list.add(matrix[x2][i]);
                }
            }
            if (y1 != y2) {
                for (int i = x2 - 1; i > x1; i--) {
                    list.add(matrix[i][y1]);
                }
            }
            x1++;
            x2--;
            y1++;
            y2--;
        }
        return list;
    }

    public static void main(String[] args) {
        q19_顺时针打印矩阵 q19_顺时针打印矩阵 = new q19_顺时针打印矩阵();
        int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}};
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(q19_顺时针打印矩阵.printMatrix(matrix));
    }
}
