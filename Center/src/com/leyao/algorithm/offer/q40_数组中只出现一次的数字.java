package com.leyao.algorithm.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class q40_数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) list.add(entry.getKey());
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }
}
