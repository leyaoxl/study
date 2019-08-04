package com.leyao.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 最坏时间复杂度n方，平均nlogn，最好nlogn
 * 空间复杂度logn～n
 * 不稳定
 */
public class Quick {
    public void sort(int[] array) {
        if (array == null || array.length == 0) return;
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(array, lo, hi);
        sort(array, lo, j - 1);
        sort(array, j + 1, hi);
    }

    private int partition(int[] array, int lo, int hi) {
        int i = lo, j = hi + 1;
        int mark = array[lo];
        while (true) {
            while (array[++i] < mark) if (i == hi) break;
            while (array[--j] > mark) if (j == lo) break;
            if (i >= j) break;
            swap(array, i, j);
        }
        swap(array, lo, j);
        return j;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Quick quick = new Quick();
        quick.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
