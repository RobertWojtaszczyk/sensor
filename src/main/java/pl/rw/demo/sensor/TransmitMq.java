package pl.rw.demo.sensor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import pl.rw.demo.sensor.domain.TempReading;

@Component
public class TransmitMq {
    private RabbitTemplate rabbitTemplate;

    public TransmitMq(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public boolean sendTemperature(String jsonBody) {
        rabbitTemplate.convertAndSend("sensor", jsonBody);
        return true;
    }

    public boolean sendTemperature(TempReading tempReading) {
        rabbitTemplate.convertAndSend("sensor", tempReading);
        System.out.println("Sending to RabbitMq tempReading = " + tempReading);
        return true;
    }

}
