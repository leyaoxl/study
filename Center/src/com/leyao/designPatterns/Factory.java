package com.leyao.designPatterns;

/**
 * 简单工厂模式
 */
interface Production {}

class Car implements Production {}

class TV implements Production {}

class SimpleFactory {
    public Production create(String type) {
        if (type.equals("TV")) {
            return new TV();
        }
        if (type.equals("Car")) {
            return new Car();
        }
        return null;
    }
}

class SimpleFactoryPattern {
    public static void main(String[] args) {
        Production car = new SimpleFactory().create("Car");
        Production tv = new SimpleFactory().create("Tv");
    }
}

/**
 * 工厂模式
 * 静态工厂则是直接给实际工厂类加static关键字
 */
interface ProductionFactory{
    Production create();
}

class CarFactory implements ProductionFactory {
    @Override
    public Production create() {
        return new Car();
    }
}

class TVFactory implements ProductionFactory {
    @Override
    public Production create() {
        return new TV();
    }
}

class FactoryPattern {
    public static void main(String[] args) {
        ProductionFactory productionFactory1 = new CarFactory();
        ProductionFactory productionFactory2 = new TVFactory();
        Production car = productionFactory1.create();
        Production tv = productionFactory2.create();
    }
}

/**
 * 抽象工厂模式
 */
class Audi extends Car {}

class BMW extends Car {}

class TCL extends TV {}

class LG extends TV {}

interface AbstractFactory {
    Car createCar();
    TV createTv();
}

class AbstractFactory1 implements AbstractFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }

    @Override
    public TV createTv() {
        return new TCL();
    }
}

class AbstractFactory2 implements AbstractFactory {
    @Override
    public Car createCar() {
        return new BMW();
    }

    @Override
    public TV createTv() {
        return new LG();
    }
}

class AbstractFactoryPattern {
    public static void main(String[] args) {
        Car car1 = new AbstractFactory1().createCar();
        TV tv1 = new AbstractFactory1().createTv();
        Car car2 = new AbstractFactory2().createCar();
        TV tv2 = new AbstractFactory2().createTv();
    }
}

public class Factory {
    public static void main(String[] args) {

    }
}
