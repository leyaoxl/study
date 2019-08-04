package com.leyao.algorithm.sort;

/**
 * 堆，构造最大堆
 * 时间复杂度nlogn
 * 空间复杂度1
 * 不稳定
 */
public class Heap {
    private int[] maxHeap;
    private int N = 0;

    public Heap(int size) {
        maxHeap = new int[size + 1];
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    private void swim(int k) {
        while (k > 1) {
            if (maxHeap[k] > maxHeap[k / 2]) {
                swap(maxHeap, k, k / 2);
                k = k / 2;
            } else break;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && maxHeap[j] < maxHeap[j + 1]) j++;
            if (maxHeap[k] >= maxHeap[j]) break;
            swap(maxHeap, k, j);
            k = j;
        }
    }

    public void insert(int num) {
        maxHeap[++N] = num;
        swim(N);
    }

    public int delMax() {
        int result = maxHeap[1];
        maxHeap[1] = maxHeap[N];
        maxHeap[N] = 0;
        N--;
        sink(1);
        return result;
    }
}
