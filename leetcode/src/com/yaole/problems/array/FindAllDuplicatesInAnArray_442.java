package com.yaole.problems.array;

import java.util.*;

public class FindAllDuplicatesInAnArray_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resultList = new LinkedList<>();
        if (nums.length == 1) return resultList;
        for (int i = 0; i < nums.length; i++) {
            int t = Math.abs(nums[i]) - 1;
            if (nums[t] > 0) nums[t] = -nums[t];
            else resultList.add(Math.abs(nums[i]));
        }
        return resultList;
    }

    // public List<Integer> findDuplicates(int[] nums) {
    //     List<Integer> resultList = new LinkedList<>();
    //     if (nums.length == 1) return resultList;
    //     Arrays.sort(nums);
    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i] == nums[i - 1]) resultList.add(nums[i]);
    //     }
    //     return resultList;
    // }

    // public List<Integer> findDuplicates(int[] nums) {
    //     List<Integer> resultList = new LinkedList<>();
    //     if (nums.length == 1) return resultList;
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int num : nums) {
    //         if (!map.containsKey(num)) map.put(num, 1);
    //         else {
    //             resultList.add(num);
    //         }
    //     }
    //     return resultList;
    // }

    // public List<Integer> findDuplicates(int[] nums) {
    //     List<Integer> resultList = new LinkedList<>();
    //     if (nums.length == 1) return resultList;
    //     loop:
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[j] == nums[i]) {
    //                 resultList.add(nums[i]);
    //                 continue loop;
    //             }
    //         }
    //     }
    //     return resultList;
    // }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray_442 findAllDuplicatesInAnArray_442 = new FindAllDuplicatesInAnArray_442();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findAllDuplicatesInAnArray_442.findDuplicates(nums));
    }
}
