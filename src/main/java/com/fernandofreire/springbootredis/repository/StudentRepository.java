package com.fernandofreire.springbootredis.repository;

import com.fernandofreire.springbootredis.models.Student;

import java.util.Map;

public interface StudentRepository {

    void save(Student student);
    Map<String, Student> findAll();
    Student findById(String id);
    void update(Student student);
    void delete(String id);

}
