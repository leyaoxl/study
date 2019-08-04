package com.yaole.problems.array;

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2, 2, 2, 3, 3, 4, 4, 5};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[j]) {
                nums[j + 1] = nums[i];
                j++;
            }
        }
        return j + 1;
    }
}
