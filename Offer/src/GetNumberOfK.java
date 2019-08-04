public class GetNumberOfK {
    public int GetNumberOfK(int[] array , int k) {
        if (array == null || array.length == 0) return 0;
        int lo = 0, hi = array.length - 1;
        int first = firstNum(array, k, lo, hi);
        int last = lastNum(array, k, lo, hi);
        if (first != -1 || last != -1) return last - first + 1;
        return 0;
    }

    private int firstNum(int[] array, int k, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (k < array[mid]) hi = mid - 1;
            else if (k > array[mid]) lo = mid + 1;
            else if (mid - 1 >= 0 && array[mid - 1] == k) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    private int lastNum(int[] array, int k, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (k < array[mid]) hi = mid - 1;
            else if (k > array[mid]) lo = mid + 1;
            else if (mid + 1 <= array.length - 1 && array[mid + 1] == k) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,3,4,5};
        System.out.println(new GetNumberOfK().GetNumberOfK(array, 3));
    }
}
