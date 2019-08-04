package com.yaole.problems.dynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) return triangle.get(0).get(0);
        int[][] nums = new int[n][n];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                nums[i][j] = triangle.get(i).get(j);
                if (i == 0) continue;
                if (j == 0) nums[i][j] += nums[i - 1][j];
                else {
                    if (i == j) nums[i][j] += nums[i - 1][j - 1];
                    else nums[i][j] += Math.min(nums[i - 1][j - 1], nums[i - 1][j]);
                }
                if (i == n - 1) {
                    if (nums[i][j] < result) result = nums[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        list1.add(7);
        triangle.add(list1);
        list2.add(-5);
        list2.add(9);
        triangle.add(list2);
        list3.add(6);
        list3.add(5);
        list3.add(2);
        triangle.add(list3);
        list4.add(-8);
        list4.add(-2);
        list4.add(-7);
        list4.add(3);
        triangle.add(list4);
        list5.add(-2);
        list5.add(6);
        list5.add(-6);
        list5.add(-1);
        list5.add(4);
        triangle.add(list5);
        System.out.println(triangle);
        Triangle_120 triangle_120 = new Triangle_120();
        System.out.println(triangle_120.minimumTotal(triangle));
    }
}
