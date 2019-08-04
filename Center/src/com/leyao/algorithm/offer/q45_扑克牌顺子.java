package com.leyao.algorithm.offer;

public class q45_扑克牌顺子 {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        int[] tmp = new int[13];
        int max = -1;
        int min = 14;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) continue;
            if (tmp[numbers[i] - 1] == 1) return false;
            tmp[numbers[i] - 1]++;
            if (numbers[i] > max) max = numbers[i];
            if (numbers[i] < min) min = numbers[i];
        }
        if (max - min > 4) return false;
        return true;
    }
}
