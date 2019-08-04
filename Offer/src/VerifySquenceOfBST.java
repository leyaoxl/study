public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
        return helper(0, sequence.length - 1, sequence);
    }

    private boolean helper(int left, int right, int[] sequence) {
        if (right <= left) return true;
        int key = sequence[right];
        int tmp = 0;
        for (int i = left; i < right; i++) {
            if (sequence[i] < key) {
                left++;
            } else {
                for (int j = i; j < right; j++) {
                    if (sequence[j] < key) {
                        return false;
                    }
                }
                tmp = i;
            }
        }
        return helper(left, tmp - 1, sequence) && helper(tmp, right - 1, sequence);
    }

    public static void main(String[] args) {
        int[] sequence = {7, 4, 6, 5};
        VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        System.out.println(verifySquenceOfBST.VerifySquenceOfBST(sequence));
    }
}
