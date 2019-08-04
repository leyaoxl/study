package com.leyao.utils.undirectedGraph;

import com.leyao.chapter.chapter1_3.Queue;
import com.leyao.chapter.chapter1_3.Stack;

public class BreadthFirstPaths {
    private int s; // 起点
    private boolean[] marked; // 所有与起点s连通的顶点标记数组
    private int[] edgeTo; // 路径数组

    /**
     * 广度优先搜索路径构造器
     * @param G
     * @param s
     */
    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        marked[s] = true;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s); // 存储每次遍历的顶点
        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // 取出队列的第一个元素
            for (int w : G.adj(v)) { // 寻找取出元素的所有邻接点
                if (!marked[w]) { // 当邻接点未被标记时
                    edgeTo[w] = v; // 设置邻接点父元素为v
                    marked[w] = true; // 标记为连通
                    queue.enqueue(w); // 加入队列， 保证一层一层的遍历
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }
}
