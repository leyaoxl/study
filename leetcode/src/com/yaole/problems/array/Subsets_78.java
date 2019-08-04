package com.yaole.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> result = new LinkedList<>();
    //     List<Integer> tmp = new LinkedList<>();
    //     result.add(tmp);
    //     buildSubsets(result, tmp, nums, 1, Integer.MIN_VALUE);
    //     return result;
    // }
    //
    // private void buildSubsets(List<List<Integer>> result, List<Integer> tmp, int[] nums, int level, int mark) {
    //     if (level > nums.length) return;
    //     for (int num : nums) {
    //         if (num > mark) {
    //             tmp.add(num);
    //             result.add(new LinkedList<>(tmp));
    //             buildSubsets(result, tmp, nums, level + 1, num);
    //             tmp.remove(tmp.size() - 1);
    //         }
    //     }
    // }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        build(result, tmp, nums, 0);
        return result;
    }

    private void build(List<List<Integer>> result, List<Integer> tmp, int[] nums, int index) {
        if (index == nums.length) result.add(new LinkedList<>(tmp));
        else {
            tmp.add(nums[index]);
            build(result, tmp, nums, index + 1);
            tmp.remove(tmp.size() - 1);
            build(result, tmp, nums, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 1, 2};
        Subsets_78 subsets_78 = new Subsets_78();
        System.out.println(subsets_78.subsets(nums));
    }
}
