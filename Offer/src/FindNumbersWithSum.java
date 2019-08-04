import java.util.ArrayList;

public class FindNumbersWithSum {
    public ArrayList<ArrayList<Integer>> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (array == null || array.length == 0) return result;
        int left = 0, right = array.length - 1;
        while (right > left) {
            int tmpSum = array[right] + array[left];
            if (tmpSum == sum) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(array[left++]);
                tmp.add(array[right--]);
                result.add(tmp);
            } else if (tmpSum < sum) left++;
            else right--;
        }
        return result;
    }

    public static void main(String[] args) {
        FindNumbersWithSum findNumbersWithSum = new FindNumbersWithSum();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(findNumbersWithSum.FindNumbersWithSum(array, 6));
    }
}
