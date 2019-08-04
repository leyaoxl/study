public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '1') count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution number = new NumberOf1Between1AndN_Solution();
        System.out.println(number.NumberOf1Between1AndN_Solution(12013));
    }
}
