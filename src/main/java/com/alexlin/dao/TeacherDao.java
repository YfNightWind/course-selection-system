package com.alexlin.dao;

import com.alexlin.model.Student;
import com.alexlin.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {

    List<Teacher> findAll();

    // 教师登录
    Teacher teacherLogin(@Param("name") String name,
                         @Param("password") String password);

    // 教师注册
    int addTeacher(@Param("name") String name,
                   @Param("password") String password);

    int deleteTeacher(int s_id);

    int updateTeacher(Teacher teacher);

    Teacher findTeacherById(int id);

    int addScount(int t_id);

}
