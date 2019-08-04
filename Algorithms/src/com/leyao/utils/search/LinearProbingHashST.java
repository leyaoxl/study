package com.leyao.utils.search;

public class LinearProbingHashST<Key, Value> {
    private int N; // 键值对数量
    private int M; // 散列表大小
    private Key[] keys; // 存放键数组
    private Value[] values; // 存放值数组

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], values[i]);
            }
        }
        M = t.M;
        keys = t.keys;
        values = t.values;
    }

    public void put(Key key, Value value) {
        if (N >= M / 2) resize(M * 2);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i] == key) return values[i];
        }
        return null;
    }

    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        // 首先找到键
        while (!keys[i].equals(key)) {
            i = (i + 1) % M;
        }
        // 删除键
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        // 将该键之后的键删除后重新添加，避免null
        while (keys[i] != null) {
            Key tmpKey = keys[i];
            Value tmpValue = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(tmpKey, tmpValue);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) resize(M / 2);
    }
}
