package com.yaole.problems.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ContainsDuplicate_217 {
    public static void main(String[] args) {
        int[] nums = new int[] {1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        boolean result = false;

        if (nums == null || nums.length == 0) {
            return result;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                map.replace(nums[i], map.get(nums[i]) + 1);
            }
        }

        Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, Integer> tmpEntry = it.next();
            if (tmpEntry.getValue() > 1) {
                result = true;
                return result;
            }
        }

        return result;
    }
}
