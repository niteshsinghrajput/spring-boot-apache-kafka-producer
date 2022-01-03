package com.nitesh.springbootapachekafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootApacheKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApacheKafkaProducerApplication.class, args);
	}

}
