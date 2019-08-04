package com.leyao.algorithm.offer;

import java.util.PriorityQueue;

public class q33_丑数 {
    public int GetUglyNumber_Solution(int index) {
        long result = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(1L);
        while (index >= 1) {
            result = minHeap.poll();
            while (!minHeap.isEmpty()) {
                if (minHeap.peek() == result) minHeap.poll();
                else break;
            }
            minHeap.add(2 * result);
            minHeap.add(3 * result);
            minHeap.add(5 * result);
            index--;
        }
        return (int) result;
    }
}
