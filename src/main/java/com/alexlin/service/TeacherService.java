package com.alexlin.service;


import com.alexlin.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    // 教师登录
    Teacher teacherLogin(String name, String password);

    int addTeacher(String name, String password);

    int deleteTeacher(int t_id);

    int updateTeacher(Teacher teacher);

    Teacher findTeacherById(int t_id);
}
