package com.leyao.algorithm.offer;

import java.util.LinkedList;
import java.util.Queue;

public class q5b_用两个队列实现栈 {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        queue1.add(node);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int result = queue1.poll();
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return result;
    }
}
