import java.util.Stack;

public class IsPopOrder {
    Stack<Integer> stack = new Stack<>();

    public boolean IsPopOrder(int [] pushA, int [] popA) {
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == popA[j]) {
                j++;
                continue;
            }
            stack.push(pushA[i]);
        }
        while (!stack.empty()) {
            int tmp = stack.pop();
            if (tmp == popA[j]) {
                j++;
            }
        }
        if (j != pushA.length) return false;
        return true;
    }

    public static void main(String[] args) {
        IsPopOrder isPopOrder = new IsPopOrder();
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(isPopOrder.IsPopOrder(pushA, popA));
    }
}
