package com.alexlin.service;


import com.alexlin.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {
    // 获得教师所有信息
    List<Teacher> findAll();

    // 教师登录
    Teacher teacherLogin(String name, String password);

    // 教师注册
    int addTeacher(String name, String password);

    int deleteTeacher(int id);

    int updateTeacher(Teacher teacher);

    Teacher findTeacherById(int t_id);
}
