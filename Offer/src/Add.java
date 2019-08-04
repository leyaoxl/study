public class Add {
    public int Add(int num1,int num2) {
        if (num1 == 0) return num2;
        if (num2 == 0) return num1;
        while (num2 != 0) {
            int tmp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = tmp;
        }
        return num1;
    }
}
