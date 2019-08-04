package chapter15;

import java.util.Arrays;
import java.util.HashMap;

class SpaceShipControls {
    void up(int i) {}
    void down(int i) {}
}

public class SpaceShipDelegation {
    SpaceShipControls controls = new SpaceShipControls();

    public void up(int i) {
        controls.up(i);
    }

    public void down(int i) {
        controls.down(i);
    }
}
