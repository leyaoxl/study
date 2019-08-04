package com.leyao.utils.undirectedGraph;

import com.leyao.chapter.chapter1_3.Bag;

/**
 * 图的数据结构
 * Graph
 * 1.返回顶点总数
 * 2.返回边总数
 * 3.添加一条新的边
 * 4.返回某个顶点的所有邻接点
 */
public class Graph {
    private final int V; // 顶点数
    private int E; // 边数
    private Bag<Integer>[] adj; // 存储各个顶点相邻顶点的数组

    /**
     * 构造器
     * @param V
     */
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); // v的邻接表添加w
        adj[w].add(v); // w的邻接表添加v
        E++; // 边的总数加1
    }

    public Iterable<Integer> adj(int v) {
        return adj[v]; // 返回顶点v的邻接表，记录着v的所有邻接点
    }

    /**
     * 打印所有的顶点及其邻接点
     * @return
     */
    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
