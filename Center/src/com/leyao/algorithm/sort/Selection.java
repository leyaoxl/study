package com.leyao.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 最坏时间复杂度n方，平均n方，最好n方
 * 空间复杂度1
 * 不稳定
 */
public class Selection {
    public void sort(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 0; i < array.length; i++) {
            int mid = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[mid]) mid = j;
            }
            swap(array, i, mid);
        }
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Selection selection = new Selection();
        selection.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
