public class RectCover {
    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int a = 1, b = 2, c = 0;
        int i = 3;
        while (i <= target) {
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        return c;
    }

    // public int RectCover(int target) {
    //     if (target == 0) return 0;
    //     if (target == 1) return 1;
    //     if (target == 2) return 2;
    //     return RectCover(target - 1) + RectCover(target - 2);
    // }
}
