package com.leyao.utils.undirectedGraph;

/**
 * 深度优先搜索
 * 只是单纯的判断与起点连通的点
 * 当所有连通的点被标记完毕时结束递归
 * 连通性验证
 */
public class DepthFirstSearch {
    private int count; // 连通的顶点数
    private boolean[] marked; // 记录与起点连通的点的数组

    public DepthFirstSearch(Graph G, int s) {
        count = 0;
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true; // 将顶点v标记为连通
        count++; // 连通数加一
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                // 遍历v的所有邻接点，没有标记时，执行深度优先搜索
                dfs(G, w);
            }
        }
    }

    /**
     * 判断顶点v是否被标记
     * @param v
     * @return
     */
    public boolean marked(int v) {
        return marked[v];
    }

    /**
     * 返回与起点连通的顶点数
     * @return
     */
    public int count() {
        return count;
    }
}
