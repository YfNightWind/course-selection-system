package com.alexlin.service.impl;

import com.alexlin.dao.StudentDao;
import com.alexlin.dao.TeacherDao;
import com.alexlin.model.Teacher;
import com.alexlin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public int addTeacher(Teacher teacher) { return teacherDao.addTeacher(teacher);}

    @Override
    public int deleteTeacher(int s_id) { return teacherDao.deleteTeacher(s_id);}

    @Override
    public int updateTeacher(Teacher teacher) {return teacherDao.updateTeacher(teacher);}

    @Override
    public Teacher findTeacherById(int id) {return teacherDao.findTeacherById(id);}}
