package pl.rw.demo.sensor;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TempSensor {
    private TransmitController transmitController = new TransmitController();
    public boolean sendTemperature() throws IOException {

        Double random = ThreadLocalRandom.current().nextDouble(-20, 60);
        DecimalFormat df = new DecimalFormat("#.##");

        String tempJson = "{\"temp\":\"" + df.format(random) + "\"}";
        return transmitController.post("http://localhost:8080/demo/temp", tempJson);
    }
}
