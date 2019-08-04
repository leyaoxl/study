public class JumpFloor {
    // public int JumpFloor(int target) {
    //     if (target == 0) return 0;
    //     if (target == 1) return 1;
    //     if (target == 2) return 2;
    //     return JumpFloor(target - 1) + JumpFloor(target - 2);
    // }

    public int JumpFloor(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int i = 3;
        int a = 1, b = 2, c = 0;
        while (i <= target) {
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        return c;
    }
}
