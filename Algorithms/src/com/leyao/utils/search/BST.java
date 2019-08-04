package com.leyao.utils.search;

import com.leyao.chapter.chapter1_3.Queue;

/**
 * 二叉查找树
 * @author leyao
 * @version 2018-9-19
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public BST() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    public Value get(Key key) {
        return get1(root, key);
        // return get2(root, key);
    }

    /**
     * 递归实现get方法
     * @param node
     * @param key
     * @return
     */
    private Value get1(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get1(node.left, key);
        else if (cmp > 0) return get1(node.right, key);
        else return node.value;
    }

    /**
     * 迭代实现get方法
     * @param node
     * @param key
     * @return
     */
    private Value get2(Node node, Key key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) return node.value;
            if (cmp < 0) node = node.left;
            else node = node.right;
        }
        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            node = new Node(key, value, 1);
            return node;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key min() {
        if (min(root) == null) return null;
        return min(root).key;
    }

    /**
     * 返回最小键
     * @param node
     * @return
     */
    private Node min(Node node) {
        if (node == null) return null;
        if (node.left != null) return min(node.left);
        return node;
    }

    public Key max() {
        return max(root);
    }

    /**
     * 返回最大键
     * @param node
     * @return
     */
    private Key max(Node node) {
        if (node == null) return null;
        if (node.right == null) return node.key;
        return max(node.right);
    }

    public Key floor(Key key) {
        if (floor(root, key) == null) return null;
        return floor(root, key).key;
    }

    /**
     * 向下取整，求小于等于key的最大键
     * 当key小于node时，结果必定在左子树中
     * 当key大于node时，只有右子树中存在小于key的键直接返回该键，否则返回node
     * @param node
     * @param key
     * @return
     */
    private Node floor(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp < 0) return floor(node.left, key);
        Node tmp = floor(node.right, key);
        if (tmp == null) return node;
        return tmp;
    }

    public Key ceiling(Key key) {
        if (ceiling(root, key) == null) return null;
        return ceiling(root, key).key;
    }

    /**
     * 向上取整，求大于等于key的最小键
     * 当key大于node时，结果必定在右子树中
     * 当key小于node时，只有左子树中存在大于key的键直接返回该键，否则返回node
     * @param node
     * @param key
     * @return
     */
    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp > 0) return ceiling(node.right, key);
        Node tmp = ceiling(node.left, key);
        if (tmp == null) return node;
        return tmp;
    }

    public Key select(int k) {
        if (select(root, k) == null) return null;
        return select(root, k).key;
    }

    /**
     * 查找方法
     * 根据输入选择排名为第k的键
     * 当左子树size大于k时，键必定在左子树中，参数传递为k
     * 当左子树size小于k时，键必定在右子树中，参数传递为k - t - 1
     * @param node
     * @param k
     * @return
     */
    private Node select(Node node, int k) {
        if (node == null) return null;
        int t = size(node.left);
        if (t > k) return select(node.left, k);
        if (t < k) return select(node.right, k - t - 1);
        return node;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    /**
     * 排名方法
     * 查找输入键key的排名
     * 当key小于node.key时，递归调用左子树的rank方法
     * 当key等于node.key时，直接返回左子树的size
     * 当key大于node.key时，需要在递归调用右子树rank方法的前提下再加上1 + t(左子树的size)
     * @param node
     * @param key
     * @return
     */
    private int rank(Node node, Key key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return size(node.left);
        if (cmp < 0) return rank(node.left, key);
        return 1 + size(node.left) + rank(node.right, key);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    /**
     * 删除最小键
     * 查找最左侧的结点，直到该结点没有左子结点，然后将其右结点给父结点的左链接
     * @param node
     * @return
     */
    private Node deleteMin(Node node) {
        if (node == null) return null;
        if (node.left == null) return node.right;
        // 将右子树给父结点的左子树，实现将最小的键删除
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    /**
     * 删除最大键
     * 查找最右侧的结点，直到该结点没有右子结点，然后将其左结点给父结点的右链接
     * @param node
     * @return
     */
    private Node deleteMax(Node node) {
        if (node == null) return null;
        if (node.right == null) return node.left;
        // 将左子树给父结点的右子树，实现将最大的键删除
        node.right = deleteMin(node.right);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {

    }

    /**
     * 删除指定键
     * 用key与当前key进行比较，如果小于，则在左子树中删除，如果大于，则在右子树中删除
     * 如果相等，首先判断是不是单链接，如果是直接返回另一链接即可
     * 如果是双链接，那么将右子树的最小值作为当前node，现在的左子树就是之前的左子树，现在的右子树是原来的右子树删除最小元素之后的树
     * @param node
     * @param key
     * @return
     */
    private Node delete(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node tmp = node;
            node = min(tmp.right);
            node.left = tmp.left;
            node.right = deleteMin(tmp.right);
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, min(), max());
        return queue;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    /**
     * 使查找二叉树支持foreach
     * 对该树进行中序遍历，范围在lo和hi之间
     * 因为是查找二叉树，所以打印出来是有序的
     * @param node
     * @param queue
     * @param lo
     * @param hi
     */
    private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
        if (node == null) return;
        int cmplo = lo.compareTo(node.key);
        int cmphi = hi.compareTo(node.key);
        if (cmplo < 0) keys(node.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(node.key);
        if (cmphi > 0) keys(node.right, queue, lo, hi);
    }

    public void print() {
        print(root);
    }

    /**
     * 直接在控制台打印该查找二叉树
     * 中序遍历
     * 顺序打印
     * @param node
     */
    private void print(Node node) {
        if (node == null) return;
        print(node.left);
        System.out.println(node.key);
        print(node.right);
    }

    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        bst.put(1, 11);
        bst.put(0, 00);
        bst.put(2, 22);
        bst.put(3, 33);
        bst.print();
        for (Integer key : bst.keys()) System.out.println(key);
    }
}