package com.leyao.utils.search;

import com.leyao.chapter.chapter1_3.Queue;

/**
 * 红黑二叉查找树
 *
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;

    private static final boolean RED = true; // 红链接的值
    private static final boolean BLACK = false; // 黑链接的值

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;
        private boolean color; // 指向该节点的链接颜色

        public Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    /**
     * 判断一个节点是不是红节点
     *
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    /**
     * 左旋转操作
     * 将右链接旋转为左链接
     *
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 右旋转操作
     * 将左链接旋转为右链接
     *
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 将左右子节点的颜色变为黑色
     * 将自身颜色变为红色
     *
     * @param h
     */
    private void flipColors(Node h) {
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }

    /**
     * 返回红黑树节点数
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    /**
     * 插入操作
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK; // 保证根节点总是黑色
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) return new Node(key, value, 1, RED); // 每插入一个新节点，其颜色是红色
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else h.value = value;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h); // 当右链接是红色，左链接是黑色， 左旋转
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h); // 当左链接是红色，子结点的左链接也是红色，右旋转
        if (isRed(h.left) && isRed(h.right)) flipColors(h); // 当左右链接都是红色，直接变色

        h.N = 1 + size(h.left) + size(h.right); // 更新结点的高度
        return h;
    }

    /**
     * get方法
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    /**
     * 获取最大键
     *
     * @return
     */
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    /**
     * 获取最小键
     *
     * @return
     */
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    /**
     * 求在树中小于等于key的最大key
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node tmp = floor(x.right, key);
        if (tmp == null) return x;
        return tmp;
    }

    /**
     * 求在树中大于等于key的最小key
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);
        Node tmp = ceiling(x.left, key);
        if (tmp == null) return x;
        return tmp;
    }

    /**
     * 选择排名为k的key
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        Node x = select(root, k);
        if (x == null) return null;
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (k < t) return select(x.left, k);
        else if (k > t) return select(x.right, k - t - 1);
        else return x;
    }

    /**
     * 返回key的排名
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    /**
     * 有序返回红黑树key
     * 无参数时返回全部key
     *
     * @return
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    /**
     * 有序返回红黑树key
     * 有参数时返回lo～hi之间所有key
     *
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        // 类似于二叉树中序遍历原理(递归)
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
}
