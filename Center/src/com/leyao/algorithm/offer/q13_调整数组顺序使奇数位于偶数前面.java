package com.leyao.algorithm.offer;

import java.util.Arrays;

public class q13_调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if ((array[i] % 2 == 0) && (array[j] % 2 == 1)) {
                    if (array[j - 1] % 2 == 0) swap(array, j, j - 1);
                }
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        q13_调整数组顺序使奇数位于偶数前面 q13_调整数组顺序使奇数位于偶数前面 = new q13_调整数组顺序使奇数位于偶数前面();
        q13_调整数组顺序使奇数位于偶数前面.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
