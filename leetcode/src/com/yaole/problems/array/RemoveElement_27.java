package com.yaole.problems.array;

public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int result = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                result++;
                if (nums[j] == val && nums[j] != nums[i]) {
                    nums[j] = nums[i];
                    nums[i] = val;
                    j++;
                }
            }
            if (nums[j] != val) {
                j++;
            }
        }
        return result;
    }
}
