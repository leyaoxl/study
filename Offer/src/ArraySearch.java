public class ArraySearch {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        int m = array.length;
        int n = array[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (array[i][j] > target) {
                i--;
            } else if (array[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
