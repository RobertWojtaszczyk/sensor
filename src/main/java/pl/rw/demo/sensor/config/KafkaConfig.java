package pl.rw.demo.sensor.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.support.serializer.StringOrBytesSerializer;
import pl.rw.demo.sensor.domain.TempReading;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class KafkaConfig {

    //@Bean
    public ProducerFactory<String, TempReading> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    //@Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> configProps = new HashMap<>();
        //configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        //configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.113:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringOrBytesSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configProps;
    }

    //@Bean
    public KafkaTemplate<String, TempReading> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
