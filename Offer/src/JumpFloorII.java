public class JumpFloorII {
    public int JumpFloorII(int target) {
        if (target == 0) return 0;
        return (int) Math.pow(2, target - 1);
    }

    public static void main(String[] args) {
        JumpFloorII jumpFloorII = new JumpFloorII();
        System.out.println(jumpFloorII.JumpFloorII(1));
    }
}
