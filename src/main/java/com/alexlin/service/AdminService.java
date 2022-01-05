package com.alexlin.service;

import com.alexlin.model.Admin;


public interface AdminService {
    // 管理员登录
    Admin adminLogin(String name, String password);

    // 管理员获取date
    Admin getDate();

    // 管理员修改date
    int modifyDate(int date);
}
