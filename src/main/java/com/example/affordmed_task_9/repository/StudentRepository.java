package com.example.affordmed_task_9.repository;
import com.example.affordmed_task_9.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

