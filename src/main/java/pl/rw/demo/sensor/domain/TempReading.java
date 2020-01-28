package pl.rw.demo.sensor.domain;

import java.io.Serializable;

public class TempReading implements Serializable {
    private static final long serialVersionUID = 1L;

    private String temp;
    private String timestamp;

    public TempReading() {
    }

    public TempReading(String temp, String timestamp) {
        this.temp = temp;
        this.timestamp = timestamp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TempReading{" +
                "temp='" + temp + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
