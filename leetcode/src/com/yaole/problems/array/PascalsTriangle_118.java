package com.yaole.problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 第118题
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 输入: 5
 * 输出:
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle_118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    tmpList.add(1);
                }
                else {
                    tmpList.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
                }
            }
            result.add(tmpList);
        }
        return result;
    }
}
