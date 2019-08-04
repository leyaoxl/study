import java.util.ArrayList;

public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 1;
        while (true) {
            int num = i;
            loop:
            while (true) {
                if (num % 2 == 0) {
                    num /= 2;
                    continue loop;
                }
                if (num % 3 == 0) {
                    num /= 3;
                    continue loop;
                }
                if (num % 5 == 0) {
                    num /= 5;
                    continue loop;
                }
                if (num == 1) {
                    list.add(i);
                }
                break loop;
            }
            i++;
            if (list.size() == index) break;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution getUglyNumber_solution = new GetUglyNumber_Solution();
        System.out.println(getUglyNumber_solution.GetUglyNumber_Solution(7));
    }
}
