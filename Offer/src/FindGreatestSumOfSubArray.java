public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int result = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp += array[i];
            if (tmp > 0) {
                if (tmp > result) {
                    result = tmp;
                }
            } else {
                if (tmp > result) {
                    result = tmp;
                }
                tmp = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-2, -8, -1, -5, -9};
        FindGreatestSumOfSubArray findGreatestSumOfSubArray = new FindGreatestSumOfSubArray();
        System.out.println(findGreatestSumOfSubArray.FindGreatestSumOfSubArray(array));
    }
}
