import java.util.Arrays;

public class ReOrderArray {
    // 冒泡排序
    public void reOrderArray(int [] array) {
        if (array.length == 0) return;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if ((array[i] % 2) == 0 && (array[j] % 2) == 1) {
                    if (array[j - 1] % 2 == 1) continue;
                    swap(array, j, j - 1);
                }
            }
        }
    }

    private void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    // 辅助数组
    // public void reOrderArray(int [] array) {
    //     int[] result = new int[array.length];
    //     int n = 0;
    //     for (int i = 0; i < array.length; i++) {
    //         if (array[i] % 2 == 1) {
    //             result[n++] = array[i];
    //         }
    //     }
    //     for (int i = 0; i < array.length; i++) {
    //         if (array[i] % 2 == 0) {
    //             result[n++] = array[i];
    //         }
    //     }
    //     System.arraycopy(result, 0, array, 0, array.length);
    // }

    public static void main(String[] args) {
        int[] array = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8};
        ReOrderArray reOrderArray = new ReOrderArray();
        reOrderArray.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
