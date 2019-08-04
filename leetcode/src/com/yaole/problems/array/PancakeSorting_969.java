package com.yaole.problems.array;

import java.util.LinkedList;
import java.util.List;

public class PancakeSorting_969 {
    /**
     * 思路：
     * 从大到小依次将数先放到第一位，然后再移到对应位置即可
     * @param A
     * @return
     */
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new LinkedList<>();
        int n = A.length;
        int m = 0;
        while (n > 0) {
            for (int i = 0; i < n; i++) {
                if (A[i] == n) {
                    m = i;
                    break;
                }
            }
            if (m > 0) {
                result.add(m + 1);
                reverse(A, m + 1);
            }
            result.add(n);
            reverse(A, n);
            n--;
        }
        return result;
    }

    private void reverse(int[] A, int index) {
        int i = 0, j = index - 1;
        while (i < j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

    }
}
