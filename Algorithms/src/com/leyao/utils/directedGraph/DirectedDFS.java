package com.leyao.utils.directedGraph;

/**
 * 有向图深度优先搜索
 * 可达性（类似于无向图的连通性）
 */
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph digraph, int s) {
        marked = new boolean[digraph.V()];
        dfs(digraph, s);
    }

    public DirectedDFS(Digraph digraph, Iterable<Integer> sources) {
        marked = new boolean[digraph.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(digraph, s);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[v]) {
                dfs(digraph, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
