import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k == 0 || k > input.length) return result;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (i < k) maxHeap.add(input[i]);
            else {
                if (maxHeap.peek() > input[i]) {
                    maxHeap.poll();
                    maxHeap.add(input[i]);
                }
            }
        }
        result.addAll(maxHeap);
        return result;
    }

    public static void main(String[] args) {
        GetLeastNumbers_Solution getLeastNumbers_solution = new GetLeastNumbers_Solution();
        int[] input = {4,5,1,6,2,7,3,8};
        System.out.println(getLeastNumbers_solution.GetLeastNumbers_Solution(input, 4));
    }
}
