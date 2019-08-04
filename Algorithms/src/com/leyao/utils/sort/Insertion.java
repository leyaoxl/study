package com.leyao.utils.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author leyao
 * @version 2018-9-11
 */
public class Insertion {
    public static void sort(int[] a) {
        if (a == null || a.length == 0) return;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) swap(a, j, j - 1);
            }
        }
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
