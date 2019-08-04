package com.leyao.utils.sort;

import java.util.Arrays;

/**
 * 基于下沉操作的堆排序
 * @author leyao
 * @version 2018-9-17
 */
public class Heap {
    private static int[] maxHeap;
    private static int N = 0;

    public Heap(int N) {
        maxHeap = new int[N + 1];
    }

    public static void insert(int a) {
        maxHeap[++N] = a;
        swim(N);
    }

    public static int delete() {
        int max = maxHeap[1];
        maxHeap[1] = maxHeap[N];
        maxHeap[N] = 0;
        N--;
        sink(1);
        return max;
    }

    public static void swim(int k) {
        while (k > 1) {
            if (maxHeap[k / 2] < maxHeap[k]) {
                swap(maxHeap, k / 2, k);
            }
            k = k / 2;
        }
    }

    public static void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && maxHeap[j] < maxHeap[j + 1]) j++;
            if (maxHeap[k] >= maxHeap[j]) break;
            swap(maxHeap, k, j);
            k = j;
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    @Override
    public String toString() {
        return Arrays.toString(maxHeap);
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        for (int i = 1; i <= 10; i++) {
            heap.insert(i);
        }
        System.out.println(heap);
    }
}
