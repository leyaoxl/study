package chapter12;

import java.util.Arrays;

class SimpleException extends Exception {
    public SimpleException() {

    }

    public SimpleException(String msg) {
        super(msg);
    }
}

public class InheritingException {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException("lalala");
    }

    public static void main(String[] args) {
        InheritingException sed = new InheritingException();
        try {
            sed.f();
        } catch (SimpleException e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
            // System.out.println(e.getClass().getName());
            // System.out.println(e.getClass().getSimpleName());
        }
    }
}
