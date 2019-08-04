package chapter14;

public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        bounded = Integer.class;
        bounded = Integer.TYPE;
    }
}
