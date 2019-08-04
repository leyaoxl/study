public class Fibonacci {
    // public int Fibonacci(int n) {
    //     if (n == 0) return 0;
    //     if (n == 1 || n == 2) return 1;
    //     return Fibonacci(n - 1) + Fibonacci(n - 2);
    // }

    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int a = 1, b = 1, c = 0;
        int i = 3;
        while (i <= n) {
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        return c;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.Fibonacci(5));
    }
}
