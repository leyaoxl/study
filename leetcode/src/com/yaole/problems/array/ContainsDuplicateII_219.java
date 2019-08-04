package com.yaole.problems.array;

import java.util.HashMap;

public class ContainsDuplicateII_219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < 2) return false;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) hashMap.put(nums[i], i);
            else {
                int temp = hashMap.get(nums[i]);
                if (i - temp <= k) return true;
                hashMap.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }
}
