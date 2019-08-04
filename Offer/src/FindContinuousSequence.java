import java.util.ArrayList;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = 1, right = 2;
        while (right > left) {
            int tmpSum = (left + right) * (right - left + 1) / 2;
            if (tmpSum == sum) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    tmp.add(i);
                }
                result.add(tmp);
                left++;
            } else if (tmpSum < sum) right++;
            else left++;
        }
        return result;
    }
}
