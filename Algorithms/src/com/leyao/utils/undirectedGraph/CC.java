package com.leyao.utils.undirectedGraph;

/**
 * 图的深度优先搜索检测任意两个顶点是否连通
 * 对所有顶点进行搜索
 * 包括未连通的几个连通子图的情况
 */
public class CC {
    private boolean[] marked; // 用来记录连通标记状态
    private int[] id; // 用来存储顶点所属的连通分量
    private int count; // 记录连通分量

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) { // 遍历所有顶点，对未被标记的顶点执行深度优先搜索，保证每个顶点都被考虑
                dfs(G, v);
                count++;
            }
        }
    }

    /**
     * 深度优先搜索递归方法
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        marked[v] = true; // 将该顶点标记为连通状态
        id[v] = count; // 将该顶点归类在当前连通分量下
        for (int w : G.adj(v)) { // 遍历该顶点的所有邻接点
            if (!marked[w]) {
                dfs(G, w); // 当未被标记时执行递归方法
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count; // 返回总的连通分量数
    }

    public int id(int v) {
        return id[v]; // 返回顶点v所属的连通分量
    }

}
