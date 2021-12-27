package com.alexlin.dao;

import com.alexlin.model.Student;
import com.alexlin.model.Teacher;

import java.util.List;

public interface TeacherDao {
<<<<<<< HEAD
    public List<Teacher> findAll();
    public int addTeacher(Teacher teacher);
    public int deleteTeacher(int s_id);
    public int updateTeacher(Teacher teacher);
    public Teacher findTeacherById(int id);
    public int addScount(int t_id);
=======
    List<Teacher> findAll();
    int addTeacher(Teacher teacher);
    int deleteTeacher(int s_id);
    int updateTeacher(Teacher teacher);
    Teacher findTeacherById(int id);
>>>>>>> e9f212da5288147a825f2f54c165b0b0e58b6791
}
