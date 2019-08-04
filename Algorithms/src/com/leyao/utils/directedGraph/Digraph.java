package com.leyao.utils.directedGraph;

import com.leyao.chapter.chapter1_3.Bag;

/**
 * 有向图数据结构
 */
public class Digraph {
    private final int V = 0; // 顶点数
    private int E; // 边数
    private Bag<Integer>[] adj; // 存储邻接点的邻接表

    /**
     * 构造器
     * @param V
     */
    public Digraph(int V) {
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Digraph() {

    }

    /**
     * 返回顶点数
     * @return
     */
    public int V() {
        return V;
    }

    /**
     * 返回边数
     * @return
     */
    public int E() {
        return E;
    }

    /**
     * 添加一条由v指向w的边
     * 只在v的邻接表里添加w元素即可
     * 因为是有向图
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    /**
     * 返回顶点v的邻接表
     * 也可以理解为从v指出的顶点的集合
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 返回当前图的反向图
     * @return
     */
    public Digraph reverse() {
        Digraph digraph = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : digraph.adj(v)) {
                digraph.addEdge(w, v); // 将所有的边反向添加进一个新的有向图对象中
            }
        }
        return digraph;
    }
}