package com.leyao.algorithm.offer;

import java.util.PriorityQueue;

public class q63_数据流中的中位数 {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

    public void Insert(Integer num) {
        if (minHeap.size() == maxHeap.size()) {
            if (maxHeap.isEmpty()) minHeap.add(num);
            else if (num < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else minHeap.add(num);
        } else {
            if (num > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            } else maxHeap.add(num);
        }
    }

    public Double GetMedian() {
        if (minHeap.size() == maxHeap.size()) return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        else return (double) minHeap.peek();
    }
}
