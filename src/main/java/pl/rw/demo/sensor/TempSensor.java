package pl.rw.demo.sensor;

import java.io.IOException;

public class TempSensor {
    private TransmitController transmitController = new TransmitController();
    public boolean sendTemperature() throws IOException {
        String tempJson = "{\"temp\":\"99.99\"}";
        return transmitController.post("http://localhost:8080/demo/temp", tempJson);
    }
}
