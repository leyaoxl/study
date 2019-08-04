package com.yaole.problems.sort;

import java.util.*;

public class IntersectionOfTwoArrays_349 {
    /**
     * 直接将nums1存入hashset中
     * 在nums2中查询是否包含nums2中的元素
     * 包含的话将该元素加入list里，并删除nums1中该元素
     * 将list中的元素填入数组中，并返回
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resultList.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
