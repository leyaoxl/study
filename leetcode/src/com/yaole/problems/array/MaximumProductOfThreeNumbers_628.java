package com.yaole.problems.array;

public class MaximumProductOfThreeNumbers_628 {
    // public static int maximumProduct(int[] nums) {
    //     Arrays.sort(nums);
    //     int n = nums.length;
    //     return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    // }

    public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;// 最小的数
        int min2 = Integer.MAX_VALUE;// 第二小的数
        int max1 = Integer.MIN_VALUE;// 第三大的数
        int max2 = Integer.MIN_VALUE;// 第二大的数
        int max3 = Integer.MIN_VALUE;// 最大的数
        for (int num : nums) {
            if (num > max3) {
                max1 = max2;
                max2 = max3;
                max3 = num;
            }
            else if (num > max2) {
                max1 = max2;
                max2 = num;
            }
            else if (num > max1) {
                max1 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            }
            else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max3);
    }

    public static void main(String[] args) {
        int[] nums = {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786};
        // int[] nums = {1,2,3,4};
        System.out.println(maximumProduct(nums));
    }
}
