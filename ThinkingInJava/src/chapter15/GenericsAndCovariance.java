package chapter15;

import java.util.ArrayList;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        List<? extends Number> list = new ArrayList<>();
    }
}
