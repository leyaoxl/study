package com.yaole.problems.array;

import java.util.Arrays;
import java.util.HashSet;

public class FairCandySwap_888 {
    public static int[] fairCandySwap(int[] A, int[] B) {
        HashSet<Integer> hashSet = new HashSet<>();
        int sumA = 0, sumB = 0;
        for (int a : A) sumA += a;
        for (int b : B) {
            hashSet.add(b);
            sumB += b;
        }
        int tmp = (sumA - sumB) / 2;
        for (int a : A) {
            if (hashSet.contains(a - tmp)) {
                return new int[]{a, a - tmp};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] A = {1,2,5};
        int[] B = {2,4};
        System.out.println(Arrays.toString(fairCandySwap(A, B)));
    }
}
