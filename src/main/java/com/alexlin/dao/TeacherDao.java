package com.alexlin.dao;

import com.alexlin.model.Student;
import com.alexlin.model.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> findAll();
    int addTeacher(Teacher teacher);
    int deleteTeacher(int s_id);
    int updateTeacher(Teacher teacher);
    Teacher findTeacherById(int id);
    int addScount(int t_id);

}
