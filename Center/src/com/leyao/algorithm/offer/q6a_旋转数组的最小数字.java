package com.leyao.algorithm.offer;

public class q6a_旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int lo = 0, hi = array.length - 1;
        while (lo < hi) {
            if (lo == hi - 1) break;
            int mid = lo + (hi - lo) / 2;
            if (array[lo] <= array[mid]) lo = mid;
            if (array[hi] >= array[mid]) hi = mid;
        }
        return array[hi];
    }
}
