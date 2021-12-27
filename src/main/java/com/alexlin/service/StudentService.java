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
    //学生导师确定，更改学生表导师号字段，state字段，导师表s_count字段
    void setTeacher(int s_id,int t_id);
    //学生差额补选,会返回选上的导师号
    int byElection(int s_id);
    //设置学生状态
    void setReady(int s_id);
    void setV1Out(int s_id);
    void setV2Out(int s_id);
    void setV3Out(int s_id);
}
