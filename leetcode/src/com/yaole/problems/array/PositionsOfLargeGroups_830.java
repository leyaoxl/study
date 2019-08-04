package com.yaole.problems.array;

import java.util.LinkedList;
import java.util.List;

public class PositionsOfLargeGroups_830 {
    public static void main(String[] args) {
        String S = "aaa";
        System.out.println(largeGroupPositions(S));
    }

    public static List<List<Integer>> largeGroupPositions(String S) {
        char[] arr = S.toCharArray();
        List<List<Integer>> resultList = new LinkedList<>();
        int nums = 0, beginNum = 0, endNum = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] == arr[j]) {
                beginNum = j;
                nums++;
                if (i == arr.length - 1) {
                    if (nums >= 3) {
                        endNum = i;
                        List<Integer> tmpList = new LinkedList<>();
                        tmpList.add(beginNum);
                        tmpList.add(endNum);
                        resultList.add(tmpList);
                        break;
                    }
                }
            }
            else {
                if (nums >= 3) {
                    endNum = i - 1;
                    List<Integer> tmpList = new LinkedList<>();
                    tmpList.add(beginNum);
                    tmpList.add(endNum);
                    resultList.add(tmpList);
                }
                j = i;
                nums = 1;
            }
        }
        return resultList;
    }
}
