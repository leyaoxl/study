public class P_字符流中第一个不重复的字符 {
    private int[] arr = new int[256];
    private int index = 1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (arr[ch] == 0) {
            arr[ch] = index++;
        } else {
            arr[ch] = -1;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int tmp = Integer.MAX_VALUE;
        char c = '#';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[i] != -1 && arr[i] < tmp) {
                tmp = arr[i];
                c = (char) i;
            }
        }
        return c;
    }
}
