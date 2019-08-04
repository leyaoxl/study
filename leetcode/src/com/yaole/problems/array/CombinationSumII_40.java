package com.yaole.problems.array;

import java.util.*;

public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> resultSet = new HashSet<>();
        List<Integer> tmp = new ArrayList<>();
        helper(resultSet, tmp, candidates, target, 0, 0);
        List<List<Integer>> result = new ArrayList<>(resultSet);
        return result;
    }

    private void helper(Set<List<Integer>> resultSet, List<Integer> tmp, int[] candidates, int target, int mark, int index) {
        if (target == 0) {
            resultSet.add(new ArrayList<>(tmp));
        }
        if (target < 0) return;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] >= mark) {
                tmp.add(candidates[i]);
                helper(resultSet, tmp, candidates, target - candidates[i], candidates[i], i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {4,4,2,1,4,2,2,1,3};
        int target = 6;
        CombinationSumII_40 combinationSumII_40 = new CombinationSumII_40();
        System.out.println(combinationSumII_40.combinationSum2(candidates, target));
    }
}
