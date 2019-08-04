package com.leyao.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度nlogn
 * 空间复杂度n
 * 稳定
 */
public class Merge {
    private int[] aux;

    public void sort(int[] array) {
        if (array == null || array.length == 0) return;
        aux = new int[array.length];
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(array, lo, mid);
        sort(array, mid + 1, hi);
        merge(array, lo, hi, mid);
    }

    private void merge(int[] array, int lo, int hi, int mid) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (aux[i] < aux[j]) array[k] = aux[i++];
            else array[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Merge merge = new Merge();
        merge.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
