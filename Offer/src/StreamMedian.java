import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    private int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.add(num);
            int tmp = maxHeap.poll();
            minHeap.add(tmp);
        } else {
            minHeap.add(num);
            int tmp = minHeap.poll();
            maxHeap.add(tmp);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        else return (double) minHeap.peek();
    }
}
