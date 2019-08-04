package com.leyao.algorithm.offer;

public class q54_字符流中第一个不重复的字符 {
    private int[] array = new int[256];
    private int mark = 1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (array[ch] == 0) {
            array[ch] = mark;
            mark++;
        } else array[ch] = -1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char result = '#';
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[i] != -1 && array[i] < tmp) {
                tmp = array[i];
                result = (char) i;
            }
        }
        return result;
    }
}
