package io.github.defective4.rpi;

import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;

public class DisplayController {
    private final DigitalOutput[] leds;

    public DisplayController(Context pi4j, int[] pins) {
        if (pins.length != 7) throw new IllegalArgumentException("pins != 7");
        leds = new DigitalOutput[pins.length];
        for (int x = 0; x < pins.length; x++) {
            leds[x] = pi4j.digitalOutput().create(pins[x]);
        }
    }

    public void clear() {
        for (DigitalOutput led : leds) led.setState(false);
    }

    public void displayCharacter(DisplayCharacter character) {
        clear();
        for (int l : character.getSegments()) leds[l].setState(true);
    }
}
