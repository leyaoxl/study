package com.yaole.problems.array;

import java.util.*;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        // 定义一个数组，用来存储candidates各个值的数量
        int[] count = new int[candidates.length];
        helper(candidates, target, 0, count, result);
        return result;
    }

    private void helper(int[] candidates, int target, int level, int[] count, List<List<Integer>> result) {
        // 当目标值被减为0，添加至result
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>();
            // 将值依次存入tmp
            for (int i = 0; i <= level; i++) {
                for (int j = 0; j < count[i]; j++) {
                    // 可以添加多个重复的值，数量是count[i]
                    tmp.add(candidates[i]);
                }
            }
            result.add(tmp);
        }
        // 当超出数组长度时返回
        if (level == candidates.length) return;
        // 当目标值小于数组值时返回
        if (target < candidates[level]) return;
        // 回溯一直找到最后
        helper(candidates, target, level + 1, count, result);
        // 当前数组元素数量自增
        count[level]++;
        // 回溯寻找差值
        helper(candidates, target - candidates[level], level, count, result);
        // 当前数组元素数量自减
        count[level]--;
    }

    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     List<Integer> tmp = new ArrayList<>();
    //     helper(result, tmp, candidates, target, 0);
    //     return result;
    // }
    //
    // private void helper(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int target, int sum) {
    //     if (sum > target) return;
    //     if (sum == target) {
    //         for (List list : result) {
    //             if (equalList(new ArrayList<>(list), new ArrayList<>(tmp))) return;
    //         }
    //         result.add(new ArrayList<>(tmp));
    //     }
    //     for (int num : candidates) {
    //         tmp.add(num);
    //         helper(result, tmp, candidates, target, sum + num);
    //         tmp.remove(tmp.size() - 1);
    //     }
    // }
    //
    // private boolean equalList(List<Integer> list1, List<Integer> list2) {
    //     if (list1.size() != list2.size()) return false;
    //     Collections.sort(list1);
    //     Collections.sort(list2);
    //     for (int i = 0; i < list1.size(); i++) {
    //         if (!list1.get(i).equals(list2.get(i))) return false;
    //     }
    //     // for (int num : list1) if (!list2.contains(num)) return false;
    //     return true;
    // }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        CombinationSum_39 combinationSum_39 = new CombinationSum_39();
        System.out.println(combinationSum_39.combinationSum(candidates, target));
    }
}
