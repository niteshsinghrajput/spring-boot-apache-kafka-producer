package com.nitesh.springbootapachekafkaproducer.process;

import com.nitesh.springbootapachekafkaproducer.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StudentKafkaProcessor {

    @Value("${producer.enabled}")
    private Boolean isJobEnabled;

    @Value("${producer.schedule}")
    private String schedule;

    @Autowired
    private StudentService service;

    @Scheduled(cron = "${producer.schedule}", zone = "CST")
    public void process() {
        if(isJobEnabled) {
            service.publish();
        }
    }
}
