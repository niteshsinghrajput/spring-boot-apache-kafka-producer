package com.nitesh.springbootapachekafkaproducer.services;

import com.nitesh.springbootapachekafkaproducer.models.Student;
import com.nitesh.springbootapachekafkaproducer.process.StudentKafkaProducer;
import com.nitesh.springbootapachekafkaproducer.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentKafkaProducer producer;

    @Override
    public List<Student> getStudents() {
        return repository.getStudents();
    }

    @Override
    public void publish() {
        boolean isPublished = false;
        List<Student> students = repository.getStudents();
        List<Student> studentsToBeUpdated = new ArrayList<>();
        if(students != null && !students.isEmpty()) {
            for(Student student: students) {
                isPublished = producer.publishToKafkaTopic(student);
                if(isPublished) {
                    student.setIsPublished(true);
                    studentsToBeUpdated.add(student);
                }
            }
            if(!studentsToBeUpdated.isEmpty()) {
                repository.saveAll(studentsToBeUpdated);
            }
        }
    }
}
