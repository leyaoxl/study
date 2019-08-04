package com.yaole.problems.string;

import java.util.Arrays;

public class StringCompression_443 {
    public int helper(int result, int num, char[] chars) {
        if (num > 1) {
            if (num < 10) {
                result = result + 1;
                chars[result - 1] = (char) (num + 48);
            }
            else if (num < 100) {
                result = result + 2;
                chars[result - 2] = (char) (num / 10 + 48);
                chars[result - 1] = (char) (num % 10 + 48);
            }
            else if (num < 1000) {
                result = result + 3;
                chars[result - 3] = (char) (num / 100 + 48);
                chars[result - 2] = (char) (num % 100 / 10 + 48);
                chars[result - 1] = (char) (num % 100 % 10 + 48);
            }
            else {
                result = result + 4;
                chars[result - 4] = (char) (num / 1000 + 48);
                chars[result - 3] = (char) (num % 1000 / 100 + 48);
                chars[result - 2] = (char) (num % 1000 % 100 / 10 + 48);
                chars[result - 1] = (char) (num % 1000 % 100 % 10 + 48);
            }
        }
        return result;
    }

    public int compress(char[] chars) {
        int result = 0;
        int num = 0;
        for (int i = 0, j = 0; i < chars.length; i++) {
            if (chars[i] == chars[j]) {
                num++;
            }
            else {
                result++;
                chars[result - 1] = chars[j];
                result = helper(result, num, chars);
                num = 1;
                j = i;
            }
            if (i == chars.length - 1) {
                result++;
                chars[result - 1] = chars[j];
                result = helper(result, num, chars);
                j = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'a', 'b', 'b', 'a', 'a', 'a'};
        StringCompression_443 stringCompression_443 = new StringCompression_443();
        System.out.println(stringCompression_443.compress(chars));
        System.out.println(Arrays.toString(chars));
    }
}
