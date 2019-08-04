import java.util.Stack;

public class QueueWithTwoStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int node) {
        s1.push(node);
    }

    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        } else {
            return s2.pop();
        }
    }
}
