package com.alexlin.dao;

import com.alexlin.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    List<Student> findAll();
    // 学生登录
    Student studentLogin(@Param("name") String name,
                         @Param("password") String password);
    // 学生注册
    int addStudent(@Param("name") String name,
                   @Param("password") String password,
                   @Param("studentNumber") String studentNumber);
    // 判断学生是否注册过
    Student findStudentByNumber(@Param("studentNumber") String studentNumber);
    int deleteStudent(int s_id);
    int updateStudent(Student student);
    Student findStudentById(int id);
    int setTeacher(Student student);
    void setState(Student student);
}
