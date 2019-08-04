package com.leyao.utils.undirectedGraph;

import com.leyao.chapter.chapter1_3.Stack;

/**
 * 图的深度优先搜索
 * 单点路径
 * 当所有连通的点被标记时递归结束
 */
public class DepthFirstPaths {
    private boolean[] marked; // 存储顶点是否与起点连通
    private int[] edgeTo; // 存储路径信息
    private int s; // 起点

    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    /**
     * 深度优先搜索
     * 递归方法
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        marked[v] = true; // 首先将该结点标记为连通
        for (int w : G.adj(v)) { // 当存在未标记的邻接点时
            if (!marked[w]) {
                edgeTo[w] = v; // 将其的上一层路径标记为v
                dfs(G, w); // 递归使用深度优先搜索
            }
        }
    }

    /**
     * 判断顶点v到起点s之间是否存在一条路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 返回起点s到顶点v的路径信息
     * @param v
     * @return
     */
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
