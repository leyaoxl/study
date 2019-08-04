package com.leyao.algorithm.offer;

import java.util.ArrayList;

public class q41_和为S的连续正数序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int left = 1, right = 2;
        while (left < right) {
            int tmp = (left + right) * (right - left + 1) / 2;
            if (tmp < sum) right++;
            else if (tmp > sum) left++;
            else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                lists.add(list);
                right++;
            }
        }
        return lists;
    }
}
