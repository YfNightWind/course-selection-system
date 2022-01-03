package com.alexlin.controller;

import com.alexlin.model.Admin;
import com.alexlin.model.Student;
import com.alexlin.model.Teacher;
import com.alexlin.service.AdminService;
import com.alexlin.service.StudentService;
import com.alexlin.service.TeacherService;
import com.alexlin.utils.ReturnContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    // 管理员登录
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

    // =================================================================================================
    // =======================================学生相关===================================================
    // =================================================================================================

    // 管理员更新学生
    @PostMapping("/updateStudent")
    @ResponseBody
    public ReturnContent updateStudent(Student student) {

        if (studentService.updateStudent(student) == 0) {
            return new ReturnContent(false, "更新失败！", "");
        } else {
            return new ReturnContent(true, "更新成功！", "");
        }
    }

    // 管理员删除学生
    @DeleteMapping("/deleteStudent")
    @ResponseBody
    public ReturnContent deleteStudent(@RequestParam(value = "number", defaultValue = "-1") int number) {

        int rows = studentService.deleteStudent(number);

        if (number == -1) {
            return new ReturnContent(false, "内容必须填写", "");
        }

        if (rows > 0) {
            return new ReturnContent(true, "删除成功！", "");
        } else {
            return new ReturnContent(false, "删除失败！", "");
        }
    }

    // 管理员获取所有学生的信息
    @GetMapping("/getAllStudent")
    @ResponseBody
    public ReturnContent getAllStudent() {
        List<Student> student = studentService.findAll();
        return new ReturnContent(true, "请求成功", student);
    }

    // 管理员添加学生
    @PostMapping("/addStudent")
    @ResponseBody
    public ReturnContent addStudent(@RequestParam(value = "name", defaultValue = "") String name,
                                    @RequestParam(value = "password", defaultValue = "") String password,
                                    @RequestParam(value = "studentNumber", defaultValue = "") String studentNumber) {

        int rows = studentService.addStudent(name, password, studentNumber);

        if (name.equals("") || password.equals("") || studentNumber.equals("")) {
            return new ReturnContent(false, "参数必须填写！", "");
        }

        if (rows > 0) {
            return new ReturnContent(true, "添加成功", "");
        } else {
            return new ReturnContent(false, "添加失败", "");
        }
    }
    // =================================================================================================
    // =======================================教师相关===================================================
    // =================================================================================================

    // 管理员获取所有教师的信息
    @GetMapping("/getAllTeacher")
    @ResponseBody
    public ReturnContent getAllTeacher() {
        List<Teacher> teachers = teacherService.findAll();
        return new ReturnContent(true, "请求成功！", teachers);
    }

    // 管理员添加教师
    @PostMapping("/addTeacher")
    @ResponseBody
    public ReturnContent addTeacher(@RequestParam(value = "name", defaultValue = "") String name,
                                    @RequestParam(value = "password", defaultValue = "") String password) {

        if (name.equals("") || password.equals("")) {
            return new ReturnContent(false, "参数必须填写！", "");
        }

        int rows = teacherService.addTeacher(name, password);

        if (rows > 0) {
            return new ReturnContent(true, "添加成功", "");
        } else {
            return new ReturnContent(false, "添加失败", "");
        }
    }

    // 管理员删除老师
    @DeleteMapping("/deleteTeacher")
    @ResponseBody
    public ReturnContent deleteTeacher(@RequestParam(value = "id", defaultValue = "-1") int id) {

        int rows = teacherService.deleteTeacher(id);

        if (id == -1) {
            return new ReturnContent(false, "内容必须填写", "");
        }

        if (rows > 0) {
            return new ReturnContent(true, "删除成功！", "");
        } else {
            return new ReturnContent(false, "删除失败！", "");
        }
    }

    // 管理员更新老师
    @PostMapping("/updateTeacher")
    @ResponseBody
    public ReturnContent updateTeacher(Teacher teacher) {

        if (teacherService.updateTeacher(teacher) == 0) {
            return new ReturnContent(false, "更新失败！", "");
        } else {
            return new ReturnContent(true, "更新成功！", "");
        }
    }

    // =================================================================================================
    // =======================================系统参数设定================================================
    // =================================================================================================

    @PostMapping("/maxStudent")
    @ResponseBody
    public ReturnContent maxStudentNumber(Teacher teacher) {

        if (teacherService.maxStudentNumber(teacher) == 0) {
            return new ReturnContent(false, "设置失败！", "");
        } else {
            return new ReturnContent(true, "设置成功！", "");
        }
    }
}
