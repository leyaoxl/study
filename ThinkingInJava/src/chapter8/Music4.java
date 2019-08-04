package chapter8;

abstract class Instrument {
    private int i;

    public abstract void play(int n);

    public String what() {
        return "Instrument";
    }

    public abstract void adjust();
}

class Wind extends Instrument {
    @Override
    public void play(int n) {
        System.out.println("Wind.play() " + n);
    }

    @Override
    public String what() {
        return "Wind";
    }

    @Override
    public void adjust() {

    }
}

class Percussion extends Instrument {
    @Override
    public void play(int n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    public String what() {
        return "Percussion";
    }

    @Override
    public void adjust() {

    }
}

class Stringed extends Instrument {
    @Override
    public void play(int n) {
        System.out.println("Stringed.play() " + n);
    }

    @Override
    public String what() {
        return "Stringed";
    }

    @Override
    public void adjust() {

    }
}

class Brass extends Wind {
    @Override
    public void play(int n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println("Brass.adjust()");
    }
}

class Woodwind extends Wind {
    @Override
    public void play(int n) {
        System.out.println("Woodwind.play() " + n);
    }

    @Override
    public String what() {
        return "Woodwind";
    }
}

public class Music4 {
    static void tune(Instrument i) {
        i.play(9999);
    }
    static void tuneAll(Instrument[] instruments) {
        for (Instrument instrument : instruments) {
            tune(instrument);
        }
    }
    public static void main(String[] args) {
        Instrument[] instruments = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(instruments);
    }
}
