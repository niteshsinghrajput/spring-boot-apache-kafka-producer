package com.nitesh.springbootapachekafkaproducer.repositories;

import com.nitesh.springbootapachekafkaproducer.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    String SQL = "select * from student where is_published=false and status=true";
    @Query(value = SQL, nativeQuery = true)
    List<Student> getStudents();

}
