package com.fernandofreire.springbootredis.controllers;

import com.fernandofreire.springbootredis.ResponseTransfer;
import com.fernandofreire.springbootredis.models.Student;
import com.fernandofreire.springbootredis.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public Student add(@PathVariable("id") String id,
                       @PathVariable("name") String name) {
        studentRepository.save(new Student(id, name, 20000L));
        return studentRepository.findById(id).get();
    }

    @GetMapping("/update/{id}/{name}")
    public Student update(@PathVariable("id") String id,
                       @PathVariable("name") String name) {
        studentRepository.save(new Student(id, name, 1000L));
        return studentRepository.findById(id).get();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResponseTransfer delete(@PathVariable("id") String id) {
        studentRepository.deleteById(id);
        return new ResponseTransfer("Thanks For Posting!!!");
    }

    @GetMapping("/all")
    public ArrayList<Student> all() {
        return (ArrayList<Student>) studentRepository.findAll();
    }
}