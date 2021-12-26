package com.alexlin.service.impl;

import com.alexlin.dao.StudentDao;
import com.alexlin.model.Student;
import com.alexlin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Student studentLogin(String name, String password) {
        return studentDao.studentLogin(name, password);
    }
}
