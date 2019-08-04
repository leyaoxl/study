import java.util.ArrayList;
import java.util.List;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int x1 = 0, y1 = 0;
        int x2 = m - 1, y2 = n - 1;
        ArrayList<Integer> result = new ArrayList<>();
        while (x1 <= x2 && y1 <= y2) {
            for (int i = y1; i <= y2; i++) {
                result.add(matrix[x1][i]);
            }
            for (int i = x1 + 1; i <= x2; i++) {
                result.add(matrix[i][y2]);
            }
            if (x1 != x2) {
                for (int i = y2 - 1; i >= y1; i--) {
                    result.add(matrix[x2][i]);
                }
            }
            if (y1 != y2) {
                for (int i = x2 - 1; i >= x1 + 1; i--) {
                    result.add(matrix[i][y1]);
                }
            }
            x1++;
            y1++;
            x2--;
            y2--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}};
        PrintMatrix printMatrix = new PrintMatrix();
        System.out.println(printMatrix.printMatrix(matrix));
    }
}
