package com.fernandofreire.springbootredis.controllers;

import com.fernandofreire.springbootredis.models.Student;
import com.fernandofreire.springbootredis.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public Student add(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        studentRepository.save(new Student(id, name, 20000L));
        return studentRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public Student update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        studentRepository.update(new Student(id, name, 1000L));
        return studentRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, Student> delete(@PathVariable("id") final String id) {
        studentRepository.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<String, Student> all() {
        return studentRepository.findAll();
    }
}