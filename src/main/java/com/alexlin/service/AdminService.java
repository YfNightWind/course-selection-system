package com.alexlin.service;

import com.alexlin.model.Admin;


public interface AdminService {
    Admin adminLogin(String name, String password);
}
