package com.leyao.utils.directedGraph;

import com.leyao.chapter.chapter1_3.Stack;

/**
 * 寻找有向图中的有向环
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;
}
