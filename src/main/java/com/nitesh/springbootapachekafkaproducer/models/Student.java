package com.nitesh.springbootapachekafkaproducer.models;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "is_published")
    private Boolean isPublished;

}
