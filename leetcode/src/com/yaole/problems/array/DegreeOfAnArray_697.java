package com.yaole.problems.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DegreeOfAnArray_697 {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[] {1, 3, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) throws InterruptedException {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                map.replace(nums[i], map.get(nums[i]) + 1);
            }
        }


        //遍历HashMap，得到数组的度
        List<Integer> tmpList = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> tmpEntry = it.next();
            if (tmpEntry.getValue() >= max) {
                max = tmpEntry.getValue();
            }
        }

        Iterator<Entry<Integer, Integer>> itLast = map.entrySet().iterator();
        while (itLast.hasNext()) {
            Map.Entry<Integer, Integer> tmpEntry = itLast.next();
            if (tmpEntry.getValue() == max) {
                tmpList.add(tmpEntry.getKey());
            }
        }

        int result = Integer.MAX_VALUE;
        Iterator<Integer> tmpListIt = tmpList.iterator();
        while (tmpListIt.hasNext()) {
            int ele = tmpListIt.next();
            int x = 0;
            int y = n - 1;
            tmp:
            while (x <= y) {
                if (nums[x] == ele && nums[y] == ele) {
                    if (y - x + 1 < result) {
                        result = y - x + 1;
                        break tmp;
                    }
                    break tmp;
                }
                else if (nums[x] == ele && nums[y] != ele) {
                    y--;
                }
                else if (nums[x] != ele && nums[y] == ele) {
                    x++;
                }
                else if (nums[x] != ele && nums[y] != ele) {
                    x++;
                    y--;
                }
                continue;
            }
        }

        return result;
    }
}