package com.yaole.problems.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII_350 {
    /**
     * 首先将nums1元素存入哈希表，key是元素，value是出现次数
     * 然后遍历nums2，每次遍历判断哈希表中是否存在当前元素
     * 如果存在，将其存入list，并将哈希表中次数减一
     * 将list存入数组，并返回数组
     * @param nums1
     * @param nums2
     * @return result
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (hashMap.containsKey(nums1[i])) {
                hashMap.put(nums1[i], hashMap.get(nums1[i]) + 1);
            }
            else hashMap.put(nums1[i], 1);
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.containsKey(nums2[i])) {
                if (hashMap.get(nums2[i]) > 0) {
                    resultList.add(nums2[i]);
                    hashMap.put(nums2[i], hashMap.get(nums2[i]) - 1);
                }
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
