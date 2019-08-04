public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        int result = array[0];
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                num++;
            } else {
                num--;
                if (num == 0) {
                    result = array[i];
                    num = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) count++;
        }
        if (count > array.length / 2) return result;
        return 0;
    }

    public static void main(String[] args) {
        MoreThanHalfNum_Solution moreThanHalfNum_solution = new MoreThanHalfNum_Solution();
        int[] array = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(moreThanHalfNum_solution.MoreThanHalfNum_Solution(array));
    }
}
