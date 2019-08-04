import java.util.*;

public class MaxInWindows {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0) return result;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (!deque.isEmpty()) {
                if (i >= deque.peek() + size) deque.poll();
            }
            while (!deque.isEmpty() && num[i] >= num[deque.getLast()]) {
                deque.pollLast();
            }
            deque.add(i);
            if (i >= size - 1) {
                result.add(num[deque.peek()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {4, 4, 6, 6, 6, 5, 4, 1};
        System.out.println(maxInWindows(num, 3));
    }
}
