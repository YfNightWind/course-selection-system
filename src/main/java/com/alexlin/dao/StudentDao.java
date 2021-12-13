package com.alexlin.dao;

import com.alexlin.model.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> findAll();
}
