package com.alexlin.service.impl;

import com.alexlin.dao.AdminDao;
import com.alexlin.model.Admin;
import com.alexlin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }
}
