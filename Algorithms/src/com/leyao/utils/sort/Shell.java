package com.leyao.utils.sort;

import java.util.Arrays;

/**
 * 希尔排序（改进的插入排序）
 * @author leyao
 * @version 2018-9-11
 */
public class Shell {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (a[j] < a[j - h]) swap(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 3, 4, 5, 6, 7, 2, 8, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
