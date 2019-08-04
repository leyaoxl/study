package com.leyao.examination;

import java.util.*;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        helper(n);
    }

    private static void helper(int n) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            if (map.isEmpty()) {
                map.put(1, 1);
                continue;
            }

            LinkedHashMap<Integer, Integer> tmp = new LinkedHashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                tmp.put(key, value);
            }
            map.clear();
            System.out.println(tmp);
            for (Map.Entry<Integer, Integer> entry : tmp.entrySet()) {
                int curAge = entry.getKey();
                map.put(curAge + 1, entry.getValue());
                if (curAge + 1 >= 3 && curAge + 1 <= 7) {
                    if (map.containsKey(1)) map.put(1, map.get(1) + entry.getValue());
                    else map.put(1, 1);
                }
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() > 10) continue;
            sum += entry.getValue();
        }
        System.out.println(sum);
    }
}
