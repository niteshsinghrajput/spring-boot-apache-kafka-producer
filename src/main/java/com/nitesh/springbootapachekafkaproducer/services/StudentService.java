package com.nitesh.springbootapachekafkaproducer.services;

import com.nitesh.springbootapachekafkaproducer.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    void publish();
}
