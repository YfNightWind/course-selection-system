package com.alexlin.controller;

import com.alexlin.model.Admin;
import com.alexlin.service.AdminService;
import com.alexlin.utils.ReturnContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @ResponseBody
    public ReturnContent adminLogin(@RequestParam(value = "name", defaultValue = "") String name,
                                    @RequestParam(value = "password", defaultValue = "") String password) {

        Admin admin = adminService.adminLogin(name, password);

        if (name.equals("") || password.equals("")) {
            return new ReturnContent(false, "参数必须填写！", "");
        }

        if (admin == null) {
            return new ReturnContent(false, "账号或密码错误", "");
        } else {
            return new ReturnContent(true, "登录成功！", admin);
        }
    }
}
