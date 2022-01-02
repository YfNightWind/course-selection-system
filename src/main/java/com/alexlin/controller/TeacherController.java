package com.alexlin.controller;

import com.alexlin.dao.TeacherDao;
import com.alexlin.model.Teacher;
import com.alexlin.utils.ReturnContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherDao teacherDao;

    // 教师登录
    @PostMapping("/login")
    @ResponseBody
    public ReturnContent teacherLogin(@RequestParam(value = "name", defaultValue = "") String name,
                                      @RequestParam(value = "password", defaultValue = "") String password) {

        Teacher teacher = teacherDao.teacherLogin(name, password);

        if (name.equals("") || password.equals("")) {
            return new ReturnContent(false, "参数必须填写！", "");
        }

        if (teacher == null) {
            return new ReturnContent(false, "账号或密码错误！", "");
        }

        return new ReturnContent(true, "登录成功！", teacher);
    }

    // 教师注册
    @PostMapping("/register")
    @ResponseBody
    public ReturnContent teacherRegister(@RequestParam(value = "name", defaultValue = "") String name,
                                         @RequestParam(value = "password", defaultValue = "") String password) {

        int register = teacherDao.addTeacher(name, password);

        if (name.equals("") || password.equals("")) {
            return new ReturnContent(false, "参数必须填写！", "");
        }

        if (register == 0) {
            return new ReturnContent(false, "注册失败!", "");
        }

        return new ReturnContent(true, "注册成功!", "");
    }

}
