package pl.rw.demo.sensor;

import org.springframework.stereotype.Component;
import pl.rw.demo.sensor.domain.TempReading;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class TempSensor {
    //private TransmitController transmitController = new TransmitController();
    private TransmitMq transmitMq;
    private TransmitKafka transmitKafka;

    public TempSensor(TransmitMq transmitMq, TransmitKafka transmitKafka) {
        this.transmitMq = transmitMq;
        this.transmitKafka = transmitKafka;
    }

    public boolean sendTemperature() throws IOException {

        Double random = ThreadLocalRandom.current().nextDouble(-20, 60);
        DecimalFormat df = new DecimalFormat("#.##");

        Instant timeStamp = Instant.now();

        TempReading tempReading = new TempReading(df.format(random), timeStamp.toString());
        transmitKafka.sendTemperature(tempReading);
        //return transmitMq.sendTemperature(tempReading);
        return true;

        //String tempJson = "{\"temp\":\"" + df.format(random) + "\"}";
        //return transmitMq.sendTemperature(tempJson);

        //return transmitController.post("http://localhost:8080/demo/temp", tempJson);
    }
}
