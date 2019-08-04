package com.yaole.problems.dynamicProgram;

public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = 0, b = i - 1;
            while (a < i && b >= 0) {
                nums[i] += nums[a++] * nums[b--];
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees_96 uniqueBinarySearchTrees_96 = new UniqueBinarySearchTrees_96();
        System.out.println(uniqueBinarySearchTrees_96.numTrees(0));
    }
}
