package com.alexlin.service;

import com.alexlin.model.Admin;


public interface AdminService {
    // 管理员登录
    Admin adminLogin(String name, String password);

    // 管理员获取date
    Admin getDate();

    // 管理员修改date
    int setReady();
    int setStart();
    //设置志愿截止
    int setV1Out();
    int setV2Out();
    int setV3Out();
    //对所有未Finish的学生进行差额补选
    //返回差额补选的学生的数量
    int byElectionAll();
}
