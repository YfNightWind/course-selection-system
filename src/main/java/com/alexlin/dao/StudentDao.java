package com.alexlin.dao;

import com.alexlin.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Student studentLogin(String name, String password);
    public int addStudent(Student student);
    public int deleteStudent(int s_id);
    public int updateStudent(Student student);
    public Student findStudentById(int id);
}
