package com.leyao.algorithm.offer;

public class q28_数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        int num = 0;
        int result = array[0];
        for (int i = 0; i < array.length; i++) {
            if (result == array[i]) num++;
            else {
                num--;
                if (num == 0) {
                    result = array[i];
                    num = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) count++;
        }
        if (count > array.length / 2) return result;
        return 0;
    }
}
