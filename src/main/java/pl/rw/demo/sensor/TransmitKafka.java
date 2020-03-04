package pl.rw.demo.sensor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pl.rw.demo.sensor.domain.TempReading;

@Component
public class TransmitKafka {
    private KafkaTemplate<String, TempReading> kafkaTemplate;

    public TransmitKafka(KafkaTemplate<String, TempReading> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTemperature(TempReading tempReading) {
        System.out.println("Sending tempReading to Kafka = " + tempReading);
        kafkaTemplate.send("sensors.temperature.topic2", tempReading);
        // kafkaTemplate.sendDefault(tempReading); // topic configured in application.prop
    }
}
