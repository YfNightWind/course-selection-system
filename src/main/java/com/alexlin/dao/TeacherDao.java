package com.alexlin.dao;

import com.alexlin.model.Student;
import com.alexlin.model.Teacher;

import java.util.List;

public interface TeacherDao {
    public List<Teacher> findAll();
    public int addTeacher(Teacher teacher);
    public int deleteTeacher(int s_id);
    public int updateTeacher(Teacher teacher);
    public Teacher findTeacherById(int id);
    public int addScount(int t_id);
}
