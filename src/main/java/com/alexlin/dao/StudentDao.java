package com.alexlin.dao;

import com.alexlin.model.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> findAll();
    public int addStudent(Student student);
    public int deleteStudent(int s_id);
    public int updateStudent(Student student);
    public Student findStudentById(int id);
}
