package com.yaole.problems.array;

import java.util.Arrays;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        int low = 0;
        int high = nums1.length - 1;
        sorted(nums1, low, high);
    }

    public static void sorted(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[start];
        while (start < end) {
            while (start < end && key <= a[end]) {
                end--;
            }
            if (key >= a[end]) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            while (start < end && key >= a[start]) {
                start++;
            }
            if (key <= a[start]) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        if (start > low) sorted(a, low, start - 1);
        if (end < high) sorted(a, end + 1, high);
    }
}
