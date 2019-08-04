package chapter16;

public class ArrayOfGenericType<T> {
    T[] array;
    public ArrayOfGenericType(int size) {
        array = (T[]) new Object[size];
    }

    public <U> U[] makeArray() {
        return (U[]) new Object[1];
    }
}
