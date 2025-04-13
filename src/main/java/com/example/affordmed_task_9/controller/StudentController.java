package com.example.affordmed_task_9.controller;
import com.example.affordmed_task_9.model.Student;
import com.example.affordmed_task_9.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = repository.findById(id).orElse(null);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setRollNumber(updatedStudent.getRollNumber());
            student.setEmail(updatedStudent.getEmail());
            student.setMobile(updatedStudent.getMobile());
            return repository.save(student);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "Deleted student with ID: " + id;
    }
}
