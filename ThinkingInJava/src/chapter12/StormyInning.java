package chapter12;

class BaseballException extends Exception {}
class Foul extends Exception {}
class Strike extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {
        throw new BaseballException();
    }
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    // 构造器不能省略基类构造器所声明的异常
    public StormyInning() throws Foul, BaseballException {}
    public StormyInning(String s) throws BaseballException, Foul {}
    public void rainHard() {}
    // 子类方法可以省略基类方法声明的异常
    public void event() {}
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (BaseballException e) {
            System.out.println(1);
        }

        try {
            Inning i = new StormyInning();
        } catch (BaseballException e) {
            System.out.println(1);
        } catch (Foul e) {
            System.out.println("Foul");
        }


    }
}
