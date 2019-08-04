package com.leyao.algorithm.offer;

public class q6b_查找旋转数组中的数字 {
    public int numberInRotateArray(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < array[mid]) {
                if (target < array[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else if (target > array[mid]) {
                if (target > array[hi]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {4,5,1,2,3};
        System.out.println(new q6b_查找旋转数组中的数字().numberInRotateArray(array, 6));
    }
}
