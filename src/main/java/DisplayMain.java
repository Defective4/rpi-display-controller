import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;

import io.github.defective4.rpi.DisplayCharacter;
import io.github.defective4.rpi.DisplayController;

public class DisplayMain {

    public static void main(String[] args) {
        Context pi4j = Pi4J.newAutoContext();
        int[] pins = {
                18, 27, 25, 24, 23, 22, 17
        };
        DisplayController display = new DisplayController(pi4j, pins);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> display.clear()));
        new Timer(false).scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                int sec = Calendar.getInstance().get(Calendar.SECOND) % 10;
                display.displayCharacter(DisplayCharacter.getForDigit(sec));
            }
        }, 0, 1000);
    }

}
