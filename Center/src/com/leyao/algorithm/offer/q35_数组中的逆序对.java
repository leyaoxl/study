package com.leyao.algorithm.offer;

public class q35_数组中的逆序对 {
    private int[] aux;
    private int count = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;
        aux = new int[array.length];
        sort(array, 0, array.length - 1);
        return count;
    }

    private void sort(int[] array, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(array, lo, mid);
        sort(array, mid + 1, hi);
        merge(array, lo, hi, mid);
    }

    private void merge(int[] array, int lo, int hi, int mid) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (aux[i] < aux[j]) array[k] = aux[i++];
            else {
                array[k] = aux[j++];
                count += mid - i + 1;
                count %= 1000000007;
            }
        }
    }
}
