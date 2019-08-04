package com.leyao.algorithm.search;

/**
 * 有序数组的二分查找
 */
public class BinarySearch {
    /**
     * 递归法
     * @param array
     * @param target
     * @return
     */
    public int binarySearch1(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        return helper(array, target, 0, array.length - 1);
    }

    private int helper(int[] array, int target, int lo, int hi) {
        if (hi < lo) return -1;
        int mid = lo + (hi - lo) / 2;
        if (target < array[mid]) return helper(array, target, lo, mid - 1);
        if (target > array[mid]) return helper(array, target, mid + 1, hi);
        return mid;
    }

    /**
     * 迭代法
     * @param array
     * @param target
     * @return
     */
    public int binarySearch2(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < array[mid]) hi = mid - 1;
            else if (target > array[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch1(array, 3));
        System.out.println(binarySearch.binarySearch2(array, 3));
    }
}
