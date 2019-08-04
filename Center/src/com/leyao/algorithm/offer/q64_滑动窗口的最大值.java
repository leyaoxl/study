package com.leyao.algorithm.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class q64_滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0) return list;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[i] > num[deque.peekLast()]) deque.pollLast();
            deque.addLast(i);
            if (deque.peekFirst() == i - size) deque.pollFirst();
            if (i >= size - 1) list.add(num[deque.peekFirst()]);
        }
        return list;
    }
}
