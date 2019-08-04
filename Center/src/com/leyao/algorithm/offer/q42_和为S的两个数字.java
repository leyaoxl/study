package com.leyao.algorithm.offer;

import java.util.ArrayList;

public class q42_和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = array.length - 1;
        while (i < j) {
            int tmp = array[i] + array[j];
            if (tmp < sum) i++;
            else if (tmp > sum) j--;
            else {
                list.add(array[i]);
                list.add(array[j]);
                break;
            }
        }
        return list;
    }
}
