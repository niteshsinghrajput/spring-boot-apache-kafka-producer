package com.nitesh.springbootapachekafkaproducer.config;

import com.nitesh.springbootapachekafkaproducer.models.Student;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StudentProducerConfig {

    public StudentProducerConfig() {

    }
    @Value("${kafka.bootstrap-server}")
    private String bootstrapServer;

    @Value("${kafka.producer.ssl.keystore-location}")
    private String keystoreLocation;

    @Value("${kafka.producer.ssl.truststore-location}")
    private String truststoreLocation;

    @Value("${kafka.producer.ssl.key-password}")
    private String keyPassword;

    @Value("${kafka.producer.ssl.keystore-password")
    private String keystorePassword;

    @Value("${kafka.producer.ssl.truststore-password}")
    private String truststorePassword;

    @Bean
    public Map<String, Object> producerConfig() {
        HashMap<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 20000);
        props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, truststoreLocation);
        props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, truststorePassword);
        props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, keyPassword);
        props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, keystoreLocation);
        props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, keystorePassword);
        return props;
    }

    @Bean
    public ProducerFactory<String, Student> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, Student> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
