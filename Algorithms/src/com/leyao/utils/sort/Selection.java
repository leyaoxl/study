package com.leyao.utils.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author leyao
 * @version 2018-8-30
 */
public class Selection {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, min, i);
        }
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
