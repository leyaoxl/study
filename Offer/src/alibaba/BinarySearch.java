package alibaba;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
                continue;
            }
            if (target > nums[mid]) {
                left = mid + 1;
                continue;
            }
            return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(nums, 8));
    }
}
