public class MinNumberInRotatedArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return 0;
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (i == j - 1) break;
            int mid = i + (j - i) / 2;
            if (array[mid] >= array[i]) {
                i = mid;
            } else if (array[mid] <= array[j]) {
                j = mid;
            }
        }
        return array[j];
    }

    public static void main(String[] args) {
        MinNumberInRotatedArray minNumberInRotatedArray = new MinNumberInRotatedArray();
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotatedArray.minNumberInRotateArray(array));
    }
}
