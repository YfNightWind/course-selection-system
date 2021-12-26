package com.alexlin.dao;

import com.alexlin.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Student studentLogin(@Param("name") String name, @Param("password") String password);
    int addStudent(Student student);
    int deleteStudent(int s_id);
    int updateStudent(Student student);
    Student findStudentById(int id);
}
