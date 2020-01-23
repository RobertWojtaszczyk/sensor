package pl.rw.demo.sensor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

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

}
