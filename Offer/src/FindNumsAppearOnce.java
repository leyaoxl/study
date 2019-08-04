import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) map.put(array[i], 1);
            else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            if (entry.getValue() == 1) {
                arr.add(entry.getKey());
            }
        }
        num1[0] = arr.get(0);
        num2[0] = arr.get(1);
    }
}
