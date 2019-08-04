package com.leyao.algorithm.offer;

import java.util.Stack;

public class q20_包含min函数的栈 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.empty()) stack2.push(node);
        else {
            if (node < stack2.peek()) stack2.push(node);
            else stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
