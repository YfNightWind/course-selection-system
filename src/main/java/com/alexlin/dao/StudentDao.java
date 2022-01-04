package com.alexlin.dao;

import com.alexlin.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    // 获得所有学生
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

    // 删除学生
    int deleteStudent(@Param("number") int number);

    // 更新学生
    int updateStudent(Student student);

    // 学生选老师
    int setTeacher(Student student);

    // 第一志愿
    List<Student> matchV1(@Param("teacherId") int teacherId);

    // 第二志愿
    List<Student> matchV2(@Param("teacherId") int teacherId);

    // 第三志愿
    List<Student> matchV3(@Param("teacherId") int teacherId);

    // 被老师选上
    int chosen(@Param("s_id") int s_id,
                   @Param("t_id") int t_id);


    void setState(Student student);
}
