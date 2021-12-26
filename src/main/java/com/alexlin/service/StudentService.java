package com.alexlin.service;

import com.alexlin.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student studentLogin(String name, String password);
    int addStudent(Student student);
    int deleteStudent(int s_id);
    int updateStudent(Student student);
    Student findStudentById(int s_id);
}
