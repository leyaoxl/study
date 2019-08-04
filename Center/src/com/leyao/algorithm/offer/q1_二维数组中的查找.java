package com.leyao.algorithm.offer;

public class q1_二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        int m = array.length;
        int n = array[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (target > array[i][j]) j++;
            else if (target < array[i][j]) i--;
            else return true;
        }
        return false;
    }
}
