package com.yaole.problems.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class TwoSum_1 {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 13)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            }
            else {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
