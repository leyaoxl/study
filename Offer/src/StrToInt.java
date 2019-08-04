public class StrToInt {
    public static int StrToInt(String str) {
        if (str.equals("") || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int mark = 0;
        if (chars[0] == '-') mark = 1;
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '-') continue;
            if (chars[i] < '0' || chars[i] > '9') return 0;
            sum = sum * 10 + chars[i] - '0';
        }
        return mark == 0 ? sum : -sum;
    }

    public static void main(String[] args) {
        String str = "+123";
        System.out.println(StrToInt(str));
    }
}
