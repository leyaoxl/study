package com.leyao.utils.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author leyao
 * @version 2018-9-12
 */
public class Quick {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int mark = a[lo];
        while (true) {
            while (a[++i] < mark) {
                if (i == hi) break;
            }
            while (a[--j] > mark) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
