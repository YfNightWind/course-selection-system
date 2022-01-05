package com.alexlin.service;


import com.alexlin.model.Student;
import com.alexlin.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {
    // 获得教师所有信息
    List<Teacher> findAll();

    // 教师登录
    Teacher teacherLogin(String name, String password);

    // 教师注册
    int addTeacher(String id, String password);

    // 管理员添加教师
    int adminAddTeacher(String name, String password, int count, int max);

    // 删除老师
    int deleteTeacher(int id);

    // 更新老师
    int updateTeacher(Teacher teacher);

    // 设置老师可选的最大学生数
    int maxStudentNumber(Teacher teacher);

    // 老师选择了该学生
    int chosen(int s_id, int t_id);

    Teacher findTeacherById(int t_id);
}
