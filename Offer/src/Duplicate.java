public class Duplicate {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) return false;
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            if (index >= length) index -= length;
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }
}
