package com.leyao.utils.search;

public class SeparateChainingHashST<Key, Value> {
    private int N; // 键值对数量
    private int M; // 散列表大小
    private SequentialSearchST<Key, Value>[] st; // 存放键值对的符号表数组

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        int index = hash(key);
        return st[index].get(key);
    }

    public void put(Key key, Value value) {
        if (N >= 8 * M) resize(2 * M); // 当链表内元素数量大于等于8时扩展散列表长度
        int index = hash(key);
        st[index].put(key, value);
    }

    private void resize(int cap) {
        SeparateChainingHashST<Key, Value> t = new SeparateChainingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            t.st[i] = st[i];
        }
        M = t.M;
        st = t.st;
    }
}
