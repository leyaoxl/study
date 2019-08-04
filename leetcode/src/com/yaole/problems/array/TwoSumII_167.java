package com.yaole.problems.array;

import java.util.Arrays;

public class TwoSumII_167 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int l = 0, r = numbers.length - 1;
        while (r > 0 && numbers[r] > target - numbers[l]) {
            r--;
        }
        while (l < r) {
            if (target == numbers[l] + numbers[r]) break;
            if (target > numbers[l] + numbers[r]) l++;
            else r--;
        }
        result[0] = l + 1;
        result[1] = r + 1;
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        System.out.println(Arrays.toString(twoSum(numbers, -1)));
    }
}
