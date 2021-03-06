package com.alexlin.service;

import com.alexlin.model.Student;

import java.util.List;

public interface StudentService {
    // 获取所有学生信息
    List<Student> findAll();

    // 学生登录
    Student studentLogin(String number, String password);

    // 学生注册
    int addStudent(String name, String password, String studentNumber);

    // 判断学生是否注册过
    Student findStudentByNumber(String studentNumber);

    // 删除学生
    int deleteStudent(int number);

    // 更新学生
    int updateStudent(Student student);

    // 学生选老师
    int setTeacher(Student student);

    // 第一志愿
    List<Student> matchV1(int teacherId);

    // 第二志愿
    List<Student> matchV2(int teacherId);

    // 第三志愿
    List<Student> matchV3(int teacherId);

    //设置学生状态
    void setReady(int s_id);

    // 一志愿落选
    int setV1Out(int s_id);

    // 二志愿落选
    int setV2Out(int s_id);

    // 三志愿落选
    int setV3Out(int s_id);

    //设置导师
    int setTid(int t_id, int s_id);

}
