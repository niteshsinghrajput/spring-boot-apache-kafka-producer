package com.nitesh.springbootapachekafkaproducer.process;

import com.nitesh.springbootapachekafkaproducer.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentKafkaProducer {

    @Value("${kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;

    public boolean publishToKafkaTopic(Student student) {
        kafkaTemplate.send(topicName, student);
        return true;
    }
}
