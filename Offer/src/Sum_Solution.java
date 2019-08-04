public class Sum_Solution {
    public int Sum_Solution(int n) {
        int ans = n;
        // 当n = 0时，前面为false，直接返回0
        boolean b = (n > 0) && ((ans += Sum_Solution(n - 1)) > 0);
        return ans;
    }
}
