package com.alexlin.controller;

import com.alexlin.model.Student;
import com.alexlin.service.StudentService;
import com.alexlin.utils.ReturnContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // 学生登录
    @PostMapping("/login")
    @ResponseBody
    public ReturnContent login(@RequestParam(value = "number", defaultValue = "") String number,
                               @RequestParam(value = "password", defaultValue = "") String password) {

        Student student = studentService.studentLogin(number, password);

        if (number.equals("") || password.equals("")) {
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

    // 学生选老师
    @PostMapping("/setTeacher")
    @ResponseBody
    public ReturnContent setTeacher(Student student) {
        /*
          应该传递四个参数，v1，v2，v3和学生的id，同时设置状态为ready
         */
        if (studentService.setTeacher(student) == 0) {
            return new ReturnContent(false, "选择失败！", "");
        } else {
            return new ReturnContent(true, "选择成功！", student);
        }
    }

    // 第一志愿
    @PostMapping("/matchV1")
    @ResponseBody
    public ReturnContent matchV1(@RequestParam(value = "teacherId", defaultValue = "-1") int teacherId) {

        if (teacherId == -1) {
            return new ReturnContent(false, "参数必须填写", "");
        }

        List<Student> student = studentService.matchV1(teacherId);

        if (student == null) {
            return new ReturnContent(false, "无学生", "");
        } else {
            return new ReturnContent(true, "第一志愿学生如下", student);
        }
    }

    // 第二志愿
    @PostMapping("/matchV2")
    @ResponseBody
    public ReturnContent matchV2(@RequestParam(value = "teacherId", defaultValue = "-1") int teacherId) {

        if (teacherId == -1) {
            return new ReturnContent(false, "参数必须填写", "");
        }

        List<Student> student = studentService.matchV1(teacherId);

        if (student == null) {
            return new ReturnContent(false, "无学生", "");
        } else {
            return new ReturnContent(true, "第二志愿学生如下", student);
        }
    }

    // 第三志愿
    @PostMapping("/matchV3")
    @ResponseBody
    public ReturnContent matchV3(@RequestParam(value = "teacherId", defaultValue = "-1") int teacherId) {

        if (teacherId == -1) {
            return new ReturnContent(false, "参数必须填写", "");
        }

        List<Student> student = studentService.matchV1(teacherId);

        if (student == null) {
            return new ReturnContent(false, "无学生", "");
        } else {
            return new ReturnContent(true, "第三志愿学生如下", student);
        }
    }

    // 一志愿落选
    @PostMapping("/v1Out")
    @ResponseBody
    public ReturnContent setV1Out(@RequestParam(value = "s_id", defaultValue = "-1") int s_id) {

        if (s_id == -1) {
            return new ReturnContent(false, "参数必须填写", "");
        }

        if (studentService.setV1Out(s_id) == 0) {
            return new ReturnContent(false, "状态设置失败", "");
        } else {
            return new ReturnContent(true, "设置状态成功", "");
        }
    }

    // 二志愿落选
    @PostMapping("/v2Out")
    @ResponseBody
    public ReturnContent setV2Out(@RequestParam(value = "s_id", defaultValue = "-1") int s_id) {

        if (s_id == -1) {
            return new ReturnContent(false, "参数必须填写", "");
        }

        if (studentService.setV2Out(s_id) == 0) {
            return new ReturnContent(false, "状态设置失败", "");
        } else {
            return new ReturnContent(true, "设置状态成功", "");
        }
    }

    // 三志愿落选
    @PostMapping("/v3Out")
    @ResponseBody
    public ReturnContent setV3Out(@RequestParam(value = "s_id", defaultValue = "-1") int s_id) {

        if (s_id == -1) {
            return new ReturnContent(false, "参数必须填写", "");
        }

        if (studentService.setV3Out(s_id) == 0) {
            return new ReturnContent(false, "状态设置失败", "");
        } else {
            return new ReturnContent(true, "设置状态成功", "");
        }
    }

}

