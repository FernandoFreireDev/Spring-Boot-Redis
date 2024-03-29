package com.fernandofreire.springbootredis.models;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash
public class Student implements Serializable {

    private String id;
    private String name;
    private Long salary;

    public Student(String id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}