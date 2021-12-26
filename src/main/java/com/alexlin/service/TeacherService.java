package com.alexlin.service;


import com.alexlin.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    int addTeacher(Teacher teacher);
    int deleteTeacher(int t_id);
    int updateTeacher(Teacher teacher);
    Teacher findTeacherById(int t_id);
}
