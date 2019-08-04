public class Multiply {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return null;
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int j = length - 2; j >= 0; j--) {
            tmp = tmp * A[j + 1];
            B[j] = B[j] * tmp;
        }
        return B;
    }
}
