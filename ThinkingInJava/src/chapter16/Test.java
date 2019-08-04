package chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    char[] c = new char[3];
    boolean[] b = new boolean[3];
    float[] f = new float[3];
    double[] d = new double[3];
    byte[] by = new byte[3];
    short[] s = new short[3];
    int[] a = new int[3];
    long[] l = new long[3];
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(Arrays.toString(test.c));
        System.out.println(Arrays.toString(test.b));
        System.out.println(Arrays.toString(test.f));
        System.out.println(Arrays.toString(test.d));
        System.out.println(Arrays.toString(test.by));
        System.out.println(Arrays.toString(test.s));
        System.out.println(Arrays.toString(test.a));
        System.out.println(Arrays.toString(test.l));

        List<String>[] ls;
        List[] la = new List[10];
        ls = la;
        ls[0] = new ArrayList<String>();
        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();
        List<Double>[] lists = (List<Double>[]) new List[10];
        lists[6] = new ArrayList<Double>();
    }
}
