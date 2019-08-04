package chapter15;

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {}

interface Lala {
    int la();
}

public class GenericsAndReturnTypes {
    void test(Getter g, Lala l) {
        Getter result = g.get();
        GenericGetter gg = g.get();
        int a = l.la();
    }
}
