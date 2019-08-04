package com.leyao.algorithm.offer;

import java.util.*;

public class q29_最小的k个数 {
    // 排序
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k == 0 || input == null || input.length == 0 || k > input.length) return list;
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            if (k == 0) break;
            list.add(input[i]);
            k--;
        }
        return list;
    }

    // 最大堆
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k == 0 || k > input.length) return list;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b.compareTo(a));
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.add(input[i]);
            } else {
                if (input[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.add(input[i]);
                }
            }
        }
        list.addAll(maxHeap);
        return list;
    }
}
