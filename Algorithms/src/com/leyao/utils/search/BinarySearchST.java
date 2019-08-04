package com.leyao.utils.search;

import com.leyao.chapter.chapter1_3.Queue;

/**
 * 基于有序数组的符号表的二分查找
 * @author leyao
 * @version 2018-9-19
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 递归实现二分查找
    private int rank(Key key, int lo, int hi) {
        if (hi < lo) return lo;
        int mid = (lo + hi) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) return rank(key, lo, mid - 1);
        else if (cmp > 0) return rank(key, mid + 1, hi);
        else return mid;
    }

    // 迭代实现二分查找
    private int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    // get方法
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) return values[i];
        return null;
    }

    // put方法
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    // 当数组中不存在该元素时，rank方法会返回该元素应该存在的位置，即大于等于其的最小元素
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i == 0) return null;
        return keys[i - 1];
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }
}
