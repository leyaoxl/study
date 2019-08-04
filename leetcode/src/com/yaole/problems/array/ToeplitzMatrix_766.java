package com.yaole.problems.array;

public class ToeplitzMatrix_766 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return true;
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
