package com.leyao.utils.undirectedGraph;

/**
 * 判断图G是否是二分图
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable;

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        isTwoColorable = true;
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v]; // 当未被标记连通时，先将其颜色标记为和父节点不同
                dfs(G, w);
            }
            else if (color[w] == color[v]) isTwoColorable = false; // 当与父节点颜色相同时，则不是二分图
        }
    }

    // 返回该图是否是二分图
    public boolean isBipartite() {
        return isTwoColorable;
    }
}
