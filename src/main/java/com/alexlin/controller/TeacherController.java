package com.alexlin.controller;

import com.alexlin.dao.TeacherDao;
import com.alexlin.model.Student;
import com.alexlin.model.Teacher;
import com.alexlin.service.TeacherService;
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
    private TeacherService teacherService;

    // 教师登录
    @PostMapping("/login")
    @ResponseBody
    public ReturnContent teacherLogin(@RequestParam(value = "name", defaultValue = "") String name,
                                      @RequestParam(value = "password", defaultValue = "") String password) {

        Teacher teacher = teacherService.teacherLogin(name, password);

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

        int register = teacherService.addTeacher(name, password);

        if (name.equals("") || password.equals("")) {
            return new ReturnContent(false, "参数必须填写！", "");
        }

        if (register == 0) {
            return new ReturnContent(false, "注册失败!", "");
        }

        return new ReturnContent(true, "注册成功!", "");
    }

    // 老师选择了该学生
    @PostMapping("/chooseStudent")
    @ResponseBody
    public ReturnContent chooseStudent(@RequestParam(value = "s_id", defaultValue = "-1") int s_id,
                                       @RequestParam(value = "t_id", defaultValue = "-1") int t_id) {

        if (s_id == -1 || t_id == -1) {
            return new ReturnContent(false, "参数必须传输", "");
        }

        int student = teacherService.chosen(s_id, t_id);

        if (student == 0) {
            return new ReturnContent(false, "选择失败", "");
        } else {
            return new ReturnContent(true, "选择成功", "");
        }
    }

}
