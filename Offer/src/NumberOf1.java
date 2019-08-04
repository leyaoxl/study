public class NumberOf1 {
    public int NumberOf1(int n) {
        if (n == 0) return 0;
        int count = 1;
        while ((n & (n - 1)) != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
