package com.alexlin.controller;

import com.alexlin.model.Student;
import com.alexlin.service.StudentService;
import com.alexlin.utils.ReturnContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        modelAndView.addObject("list",studentService.findAll());
        return modelAndView;
    }

    // 学生登录
    @PostMapping("/login")
    public ReturnContent login(@RequestParam(value = "name", defaultValue = "") String name,
                               @RequestParam(value = "password",defaultValue = "") String password) {

        Student student = studentService.studentLogin(name, password);

        if (student == null) {
            return new ReturnContent(false, "错误", "");
        } else {
            return new ReturnContent(true, "成功", student);
        }
    }
}
