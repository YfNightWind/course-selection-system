package com.alexlin.dao;

import com.alexlin.model.Student;
import com.alexlin.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {

    // 获得教师所有信息
    List<Teacher> findAll();

    // 教师登录
    Teacher teacherLogin(@Param("name") String name,
                         @Param("password") String password);

    // 教师注册
    int addTeacher(@Param("name") String name,
                   @Param("password") String password);

    // 删除教师
    int deleteTeacher(@Param("id") int id);

    // 更新教师
    int updateTeacher(Teacher teacher);

    Teacher findTeacherById(int id);

    int addScount(int t_id);

}
