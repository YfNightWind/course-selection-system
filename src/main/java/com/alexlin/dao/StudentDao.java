package com.alexlin.dao;

import com.alexlin.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    Student studentLogin(String name, String password);
}
