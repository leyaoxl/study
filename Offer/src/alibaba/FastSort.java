package alibaba;

import java.util.Arrays;

public class FastSort {
    public void sort(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) return;
        int partition = partition(nums, lo, hi);
        sort(nums, lo, partition - 1);
        sort(nums, partition + 1, hi);
    }

    public int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int key = nums[lo];
        while (true) {
            while (nums[++i] < key) {
                if (i == hi) break;
            }
            while (key < nums[--j]) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {};
        FastSort fastSort = new FastSort();
        fastSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
