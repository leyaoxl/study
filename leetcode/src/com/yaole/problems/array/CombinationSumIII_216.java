package com.yaole.problems.array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
    static final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helper(result, tmp, k, n, 0, -1);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> tmp, int k, int n, int level, int mark) {
        if (level > k) return;
        if (n == 0 && tmp.size() == k) result.add(new ArrayList<>(tmp));
        for (int num : nums) {
            if (num > mark) {
                tmp.add(num);
                helper(result, tmp, k, n - num, level + 1, num);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIII_216 combinationSumIII_216 = new CombinationSumIII_216();
        System.out.println(combinationSumIII_216.combinationSum3(3, 9));
    }
}
