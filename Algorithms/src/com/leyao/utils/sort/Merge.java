package com.leyao.utils.sort;

import java.util.Arrays;

/**
 * 自顶向下的归并排序
 * @author leyao
 * @version 2018-9-12
 */
public class Merge {
    private static int[] aux;

    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, hi, mid);
    }

    public static void merge(int[] a, int lo, int hi, int mid) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
