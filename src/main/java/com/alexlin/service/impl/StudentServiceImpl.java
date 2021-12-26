package com.alexlin.service.impl;

import com.alexlin.dao.StudentDao;
import com.alexlin.model.Student;
import com.alexlin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
<<<<<<< HEAD
    public Student studentLogin(String name, String password) {
        return studentDao.studentLogin(name, password);
    }
=======
    public int addStudent(Student student) { return studentDao.addStudent(student);}

    @Override
    public int deleteStudent(int s_id) { return studentDao.deleteStudent(s_id);}

    @Override
    public int updateStudent(Student student) {return studentDao.updateStudent(student);}

    @Override
    public Student findStudentById(int id) {return studentDao.findStudentById(id);}
>>>>>>> e72843a931d1b049f9d577271fc16e80cb064b80
}
