package com.fernandofreire.springbootredis.repository;

import com.fernandofreire.springbootredis.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class StudentRepositoryImple implements StudentRepository {

    @Autowired
    private RedisTemplate<String,Student> redisTemplate;

    private HashOperations hashOperations;


    public StudentRepositoryImple(RedisTemplate<String, Student> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Student student) {
        hashOperations.put("STUDENT", student.getId(), student);
    }

    @Override
    public Map<String, Student> findAll() {
        return hashOperations.entries("STUDENT");
    }

    @Override
    public Student findById(String id) {
        return (Student)hashOperations.get("STUDENT", id);
    }

    @Override
    public void update(Student student) {
        save(student);
    }

    @Override
    public void delete(String id) {

        hashOperations.delete("STUDENT", id);
    }

    public RedisTemplate<String, Student> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Student> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


}
