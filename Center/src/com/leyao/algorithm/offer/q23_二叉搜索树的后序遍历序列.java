package com.leyao.algorithm.offer;

public class q23_二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return helper(sequence, 0, sequence.length - 1);
    }

    private boolean helper(int[] array, int lo, int hi) {
        if (hi <= lo) return true;
        int topNode = array[hi];
        int index = 0;
        for (int i = lo; i < hi; i++) {
            if (array[i] < topNode) continue;
            index = i;
            for (int j = i; j < hi; j++) {
                if (array[j] < topNode) return false;
            }
            break;
        }
        return helper(array, lo, index - 1) && helper(array, index, hi - 1);
    }
}
