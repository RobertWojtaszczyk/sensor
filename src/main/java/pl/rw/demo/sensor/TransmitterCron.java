package pl.rw.demo.sensor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TransmitterCron {
    private static final String CRON_EVERY_TWO_MINUTES = "0 0/2 * ? * *";

    @Scheduled(cron = CRON_EVERY_TWO_MINUTES)
    //@Scheduled(fixedDelay = 1000)
    public void sendTemperature() {
        System.out.println("Starting crone job");
        TempSensor tempSensor = new TempSensor();
        try {
            tempSensor.sendTemperature();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
