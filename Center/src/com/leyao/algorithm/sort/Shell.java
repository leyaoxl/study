package com.leyao.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 最坏时间复杂度n方，最好n的1.3次方
 * 空间复杂度1
 * 不稳定
 */
public class Shell {
    public void sort(int[] array) {
        if (array == null || array.length == 0) return;
        int h = 1;
        int n = array.length;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h; j--) {
                    if (array[j] < array[j - h]) swap(array, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Shell shell = new Shell();
        shell.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
