package chapter16;

public class GroundHog {
    protected int number;
    public GroundHog(int n) {
        number = n;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof GroundHog && (number == ((GroundHog) obj).number);
    }
}
