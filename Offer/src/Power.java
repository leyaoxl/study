public class Power {
    public double Power(double base, int exponent) {
        double m = base;
        int n = exponent;
        double result = 1.0;
        if (base == 0) {
            if (exponent == 0) throw new RuntimeException("0的0次方无意义");
            return 0;
        }
        if (exponent == 0) { return 1; }
        if (exponent < 0) { n = -n; }
        // 降幂操作
        while (n != 0) {
            if ((n & 1) == 1) result *= m;
            m *= m;
            n = n >> 1;
        }
        return exponent > 0 ? result : (1 / result);
    }

    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.Power(-1.2, -1));
        int a = 5;
        System.out.println(Integer.toBinaryString(a));
        a = a >> 1;
        System.out.println(Integer.toBinaryString(a));
    }
}
