package com.leyao.chapter.chapter1_3;

/**
 * @author leyao
 * @version 2018-9-4
 */
public class Exercise_19 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        System.out.println(list);
        list.deleteFirstNode();
        System.out.println(list);
        list.deleteLastNode();
        System.out.println(list);
    }
}
