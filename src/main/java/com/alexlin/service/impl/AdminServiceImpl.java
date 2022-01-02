package com.alexlin.service.impl;

import com.alexlin.dao.AdminDao;
import com.alexlin.dao.StudentDao;
import com.alexlin.model.Admin;
import com.alexlin.model.Student;
import com.alexlin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public Admin adminLogin(String name, String password) {
        return adminDao.adminLogin(name, password);
    }

    // 删除学生
    public int deleteStudent(int s_id) {
        return studentDao.deleteStudent(s_id);
    }

    // 更新学生信息
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }
}
