package com.leyao.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.getResult(2, 3);
    }

    public void getResult(int k, int n) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = new int[k + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        helper(lists, list, k, 1, array, n);
        System.out.println(lists);
    }

    public void helper(
            ArrayList<ArrayList<Integer>> lists,
            ArrayList<Integer> list,
            int target,
            int level,
            int[] array,
            int n) {
        if (level == n + 1) {
            if (target == 0) {
                lists.add(new ArrayList<>(list));
                return;
            }
            return;
        }
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
            helper(lists, list, target - array[i], level + 1, array, n);
            list.remove(list.size() - 1);
        }
    }
}
