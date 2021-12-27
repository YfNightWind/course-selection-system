package com.alexlin.service.impl;

import com.alexlin.dao.StudentDao;
import com.alexlin.dao.TeacherDao;
import com.alexlin.model.Student;
import com.alexlin.model.Teacher;
import com.alexlin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public Student studentLogin(String name, String password) {
        return studentDao.studentLogin(name, password);
    }

    public int addStudent(Student student) { return studentDao.addStudent(student);}

    @Override
    public int deleteStudent(int s_id) { return studentDao.deleteStudent(s_id);}

    @Override
    public int updateStudent(Student student) {return studentDao.updateStudent(student);}

    @Override
    public Student findStudentById(int id) {return studentDao.findStudentById(id);}


    @Override
    public void setTeacher(int s_id, int t_id) {
        Student student = new Student();
        student.setState("Finish");
        student.setT_id(t_id);
        student.setS_id(s_id);
        studentDao.setTeacher(student);
        teacherDao.addScount(t_id);
    }

    @Override
    public int byElection(int s_id) {
        int t_id=0;
        List<Teacher> teacherList = teacherDao.findAll();
        for(Teacher teacher:teacherList){
            if(teacher.getS_count()<teacher.getS_max()){
                t_id = teacher.getT_id();
                Student student = new Student();
                student.setS_id(s_id);
                student.setT_id(t_id);
                //学生导师确定
                setTeacher(s_id,t_id);
                break;
            }
        }
        return  t_id;
    }

    @Override
    public void setReady(int s_id) {
        Student student = new Student();
        student.setState("Ready");
        student.setS_id(s_id);
        studentDao.setState(student);
    }

    @Override
    public void setV1Out(int s_id) {
        Student student = new Student();
        student.setState("V1Out");
        student.setS_id(s_id);
        studentDao.setState(student);
    }

    @Override
    public void setV2Out(int s_id) {
        Student student = new Student();
        student.setState("V2Out");
        student.setS_id(s_id);
        studentDao.setState(student);
    }

    @Override
    public void setV3Out(int s_id) {
        Student student = new Student();
        student.setState("V3Out");
        student.setS_id(s_id);
        studentDao.setState(student);
    }


}
