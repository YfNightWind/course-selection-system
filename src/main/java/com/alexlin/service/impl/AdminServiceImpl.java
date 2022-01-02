package com.alexlin.service.impl;

import com.alexlin.dao.AdminDao;
import com.alexlin.dao.StudentDao;
import com.alexlin.model.Admin;
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

}
