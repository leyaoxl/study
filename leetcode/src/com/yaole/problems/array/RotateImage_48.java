package com.yaole.problems.array;

import java.util.Arrays;

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int row = m;
        int col = n;

        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int x1 = i, y1 = j;
                int x2 = j, y2 = row - i;
                int x3 = row - i, y3 = col - j;
                int x4 = col - j, y4 = i;
                swap(matrix, x1, y1, x2, y2);
                swap(matrix, x1, y1, x3, y3);
                swap(matrix, x1, y1, x4, y4);
            }
            m--;
            n--;
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        RotateImage_48 rotateImage_48 = new RotateImage_48();
        rotateImage_48.rotate(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println(Arrays.toString(matrix[3]));
    }
}
