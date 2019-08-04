package com.leyao.utils.search;

/**
 * 基于无序链表的符号表的顺序查找
 * @author leyao
 * @version 2018-9-19
 */
public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node node = first; node != null; node = node.next) {
            if (node.key.equals(key)) return node.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node node = first; node != null; node = node.next) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        Node oldFirst = first;
        first = new Node(key, value, oldFirst);
    }
}
