package com.alexlin.service.impl;

import com.alexlin.dao.StudentDao;
import com.alexlin.dao.TeacherDao;
import com.alexlin.model.Student;
import com.alexlin.model.Teacher;
import com.alexlin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }


    public Student studentLogin(String number, String password) {
        return studentDao.studentLogin(number, password);
    }

    @Override
    public int addStudent(String name, String password, String studentNumber) {
        return studentDao.addStudent(name, password, studentNumber);
    }

    @Override
    public Student findStudentByNumber(String studentNumber) {
        return studentDao.findStudentByNumber(studentNumber);
    }

    @Override
    public int deleteStudent(int number) {
        return studentDao.deleteStudent(number);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int setTeacher(Student student) {
        return studentDao.setTeacher(student);
    }

    @Override
    public List<Student> matchV1(int teacherId) {
        return studentDao.matchV1(teacherId);
    }

    @Override
    public List<Student> matchV2(int teacherId) {
        return studentDao.matchV2(teacherId);
    }

    @Override
    public List<Student> matchV3(int teacherId) {
        return studentDao.matchV3(teacherId);
    }



    @Override
    public void setReady(int s_id) {
        Student student = new Student();
        student.setState("Ready");
        student.setS_id(s_id);
        studentDao.setState(student);
    }

    @Override
    public int setV1Out(int s_id) {
        return studentDao.setV1Out(s_id);
    }

    @Override
    public int setV2Out(int s_id) {
        return studentDao.setV2Out(s_id);
    }

    @Override
    public int setV3Out(int s_id) {
        return studentDao.setV3Out(s_id);
    }

    @Override
    public int setTid(int t_id, int s_id) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("t_id",t_id);
        map.put("s_id",s_id);
        return studentDao.setTid(map);
    }




}
