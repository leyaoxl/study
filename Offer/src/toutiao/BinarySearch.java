package toutiao;

public class BinarySearch {
    public int BinarySearch(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int lo = 0;
        int hi = array.length - 1;
        int result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            result = mid;
            if (target < array[mid]) hi = mid - 1;
            else if (target > array[mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        if (result == array.length - 1 && target > array[array.length - 1]) return -1;
        if (result == 0 && target < array[0]) return -1;
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10, 11, 11, 11, 12, 134, 134, 136};
        System.out.println(new BinarySearch().BinarySearch(array, 155));
    }
}