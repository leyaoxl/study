import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : numbers) list.add(num);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : list) stringBuilder.append(num);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        PrintMinNumber printMinNumber = new PrintMinNumber();
        int[] numbers = {3, 32, 321};
        System.out.println(printMinNumber.PrintMinNumber(numbers));
    }
}
