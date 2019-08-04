package com.leyao.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 最坏时间复杂度n方，平均n方，最好n
 * 空间复杂度1
 * 稳定
 */
public class Insertion {
    public void sort(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) swap(array, j, j - 1);
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Insertion insertion = new Insertion();
        insertion.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
