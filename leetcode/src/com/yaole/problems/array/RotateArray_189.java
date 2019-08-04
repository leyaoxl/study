// package com.yaole.problems.array;
//
// import java.util.Arrays;
//
// public class RotateArray_189 {
//     public static void main(String[] args) {
//         int[] nums = {1, 2, 3, 4, 5, 6, 7};
//         int k = 3;
//         RotateArray_189 rotateArray_189 = new RotateArray_189();
//         rotateArray_189.rotate(nums, k);
//         System.out.println(Arrays.toString(nums));
//     }
//
//     public void rotate(int[] nums, int k) {
//         k = k % nums.length;
//         int[] result = new int[nums.length];
//         for (int i = 0; i < nums.length - k; i++) {
//             result[k + i] = nums[i];
//         }
//         for (int j = 0; j < k; j++) {
//             result[k - 1 - j] = nums[nums.length - 1 - j];
//         }
//         for (int l = 0; l < nums.length; l++) {
//             nums[l] = result[l];
//         }
//         System.out.println(Arrays.toString(nums));
//     }
// }
