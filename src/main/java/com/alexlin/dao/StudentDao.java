package com.alexlin.dao;

import com.alexlin.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    // 获得所有学生
    List<Student> findAll();

    // 学生登录
    Student studentLogin(@Param("number") String number,
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

    // 一志愿落选
    int setV1Out(@Param("s_id") int s_id);

    // 二志愿落选
    int setV2Out(@Param("s_id") int s_id);

    // 三志愿落选
    int setV3Out(@Param("s_id") int s_id);

    void setState(Student student);
    //通过名字得到学生的全部信息
    int setAll(String state);
    int setVOut(String VOut);
    //设置导师
    int setTid(Map map);
    //得到所有未确定导师的学生
    List<Student> getAllNotFinish();
}
