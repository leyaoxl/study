package com.leyao.algorithm.offer;

public class q37_数字在排序数组中出现的次数 {
    // 直接遍历
    public int GetNumberOfK1(int[] array , int k) {
        if (array == null || array.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) count++;
        }
        return count;
    }

    // 二分查找
    public int GetNumberOfK2(int[] array , int k) {
        if (array == null || array.length == 0) return 0;
        int leftIndex = leftIndex(array, k);
        int rightIndex = rightIndex(array, k);
        if (leftIndex == -1 || rightIndex == -1) return 0;
        return rightIndex - leftIndex + 1;
    }

    private int leftIndex(int[] array, int k) {
        int lo = 0, hi = array.length - 1;
        int leftIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (k < array[mid]) hi = mid - 1;
            else if (k > array[mid]) lo = mid + 1;
            else {
                leftIndex = mid;
                hi = mid - 1;
            }
        }
        return leftIndex;
    }

    private int rightIndex(int[] array, int k) {
        int lo = 0, hi = array.length - 1;
        int rightIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (k < array[mid]) hi = mid - 1;
            else if (k > array[mid]) lo = mid + 1;
            else {
                rightIndex = mid;
                lo = mid + 1;
            }
        }
        return rightIndex;
    }
}
