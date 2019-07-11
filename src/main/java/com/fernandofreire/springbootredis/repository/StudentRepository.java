package com.fernandofreire.springbootredis.repository;

import com.fernandofreire.springbootredis.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {}