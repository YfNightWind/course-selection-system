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

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public Teacher teacherLogin(String name, String password) {
        return teacherDao.teacherLogin(name, password);
    }

    @Override
    public int addTeacher(String name, String password) {
        return teacherDao.addTeacher(name, password);
    }

    @Override
    public int adminAddTeacher(String name, String password, int count, int max) {
        return teacherDao.adminAddTeacher(name, password, count, max);
    }

    @Override
    public int deleteTeacher(int id) {
        return teacherDao.deleteTeacher(id);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public int maxStudentNumber(Teacher teacher) {
        return teacherDao.maxStudentNumber(teacher);
    }

    @Override
    public int chosen(int s_id, int t_id) {
        teacherDao.addScount(t_id);
        return studentDao.chosen(s_id, t_id);
    }

    @Override
    public Teacher findTeacherById(int id) {
        return teacherDao.findTeacherById(id);
    }
    @Override
    public int byElection(int s_id) {
        int t_id = 0;
        List<Teacher> teacherList = teacherDao.findAll();
        for (Teacher teacher : teacherList) {
            if (teacher.getS_count() < teacher.getS_max()) {
                t_id = teacher.getT_id();
                //学生导师确定
                chosen(s_id, t_id);
                break;
            }
        }
        return t_id;
    }
}
