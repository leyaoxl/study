package com.leyao.algorithm.offer;

import java.util.Stack;

public class q21_栈的压入弹出序列 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
