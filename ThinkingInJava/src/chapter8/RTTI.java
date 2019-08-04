package chapter8;

class Useful {
    public void f() {}
    public void g() {}
}

class MoreUseful extends Useful {
    public void f() {}
    public void g() {}
    public void u() {}
    public void v() {}
    public void w() {}
}

public class RTTI {
    public static void main(String[] args) {
        Useful[] usefuls = {
                new Useful(),
                new MoreUseful()
        };
        usefuls[0].f();
        usefuls[1].g();
        // ((MoreUseful) usefuls[0]).u();
        ((MoreUseful) usefuls[1]).u();
    }
}
