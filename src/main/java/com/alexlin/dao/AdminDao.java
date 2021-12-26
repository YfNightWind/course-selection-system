package com.alexlin.dao;

import com.alexlin.model.Admin;

import java.util.List;

public interface AdminDao {
    List<Admin> findAll();
}
