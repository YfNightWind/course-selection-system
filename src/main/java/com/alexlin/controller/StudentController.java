package com.alexlin.controller;

import com.alexlin.model.Student;
import com.alexlin.service.StudentService;
import com.alexlin.utils.ReturnContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list", studentService.findAll());
        return modelAndView;
    }

    // 学生登录
    @PostMapping("/login")
    @ResponseBody
    public ReturnContent login(@RequestParam(value = "name", defaultValue = "") String name,
                               @RequestParam(value = "password", defaultValue = "") String password) {

        Student student = studentService.studentLogin(name, password);

        if (name.equals("") || password.equals("")) {
            return new ReturnContent(false, "用户名密码不能为空！", "");
        }

        if (student == null) {
            return new ReturnContent(false, "用户不存在！", "");
        } else {
            return new ReturnContent(true, "登录成功！", student);
        }
    }

    // 学生注册
    @PostMapping("/register")
    @ResponseBody
    public ReturnContent register(@RequestParam(value = "name", defaultValue = "") String name,
                                  @RequestParam(value = "password", defaultValue = "") String password,
                                  @RequestParam(value = "studentNumber", defaultValue = "") String studentNumber) {

        int student = studentService.addStudent(name, password, studentNumber);

        if (name.equals("") || password.equals("") || studentNumber.equals("")) {
            return new ReturnContent(false, "参数都必须填写", "");
        }

        if (student == 0) {
            return new ReturnContent(false, "注册失败", "");
        }

        return new ReturnContent(true, "注册成功！", "");
    }

}

