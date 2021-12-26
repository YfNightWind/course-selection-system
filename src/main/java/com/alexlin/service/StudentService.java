package com.alexlin.service;

import com.alexlin.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student studentLogin(String name, String password);
}
