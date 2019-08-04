package com.yaole.problems.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {
    // /**
    //  * 基于哈希表法求众数
    //  * @param nums
    //  * @return
    //  */
    // public static int majorityElement(int[] nums) {
    //     HashMap<Integer, Integer> hashMap = new HashMap<>();
    //     int n = nums.length;
    //     for (int i = 0; i < n; i++) {
    //         if (!hashMap.containsKey(nums[i])) hashMap.put(nums[i], 1);
    //         else hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
    //     }
    //     int result = 0;
    //     for (Map.Entry<Integer, Integer> s : hashMap.entrySet()) {
    //         if (s.getValue() > n / 2) {
    //             result = s.getKey();
    //             break;
    //         }
    //     }
    //     return result;
    // }

    /**
     * 基于摩尔投票法求众数
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int num = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) num++;
            else {
                num--;
                if (num == 0) {
                    result = nums[i];
                    num = 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }
}
