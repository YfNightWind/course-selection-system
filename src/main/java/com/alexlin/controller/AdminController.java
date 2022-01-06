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
import org.springframework.ui.ModelMap;
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

    @GetMapping("/showStudent")
    public String showStudent(ModelMap model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("list", studentList);
        return "admin/showStudent";
    }

    @GetMapping("/showTeacher")
    public String showTeacher(ModelMap model) {
        System.out.println("here is amdin showStudent--------------------------");
        List<Teacher> list = teacherService.findAll();

        model.addAttribute("list", list);
        return "admin/showTeacher";
    }

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

    // 管理员获取date
    @GetMapping("/getDate")
    @ResponseBody
    public ReturnContent getDate() {
        return new ReturnContent(true, "成功", adminService.getDate().getDate());
    }

//    // 管理员修改date
//    @PostMapping("/modifyDate")
//    @ResponseBody
//    public ReturnContent modifyDate(@RequestParam(value = "date", defaultValue = "-2") int date) {
//
//        if (date == -2) {
//            return new ReturnContent(false, "参数必须填写", "");
//        }
//
//        int row = adminService.modifyDate(date);
//
//        if (row == 0) {
//            return new ReturnContent(false, "修改失败", "");
//        } else {
//            return new ReturnContent(true, "修改成功！", "");
//        }
//    }

    // =================================================================================================
    // =======================================学生相关===================================================
    // =================================================================================================

    // 管理员更新学生
    @PostMapping("/updateStudent")
    @ResponseBody
    public ReturnContent updateStudent(@RequestBody Student student) {

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
                                    @RequestParam(value = "password", defaultValue = "") String password,
                                    @RequestParam(value = "count", defaultValue = "0") int count,
                                    @RequestParam(value = "max", defaultValue = "10") int max) {

        if (name.equals("") || password.equals("")) {
            return new ReturnContent(false, "参数必须填写！", "");
        }

        int rows = teacherService.adminAddTeacher(name, password, count, max);

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

    //学生开始选择导师
    @PostMapping("/setState")
    @ResponseBody
    public ReturnContent setState(@RequestParam(value = "state", defaultValue = "") String state) {
        System.out.println(state);
        String msg = "学生填报志愿中";
        if (state.equals("Start")) {
            //学生填报志愿阶段
            adminService.setStart();
        } else if (state.equals("Ready")) {
            adminService.setReady();
            msg = "学生填报志愿结束，导师对第一志愿为自身的学生进行选择";
        } else if (state.equals("V1Out")) {
            adminService.setV1Out();
            msg = "第一志愿选择时间截止，导师对第二志愿为自身的学生进行选择";
        } else if (state.equals("V2Out")) {
            adminService.setV2Out();
            msg = "第二志愿选择时间截止，导师对第三志愿为自身的学生进行选择";
        } else if (state.equals("V3Out")) {
            adminService.setV3Out();
            msg = "第三志愿选择时间截止，进行差额补选";
        } else if (state.equals("byElection")) {
            adminService.byElectionAll();
            msg = "所有学生差额补选完成";
        }

        return new ReturnContent(true, msg, "");
    }

    @GetMapping("/setTime")
    public String setTime(@RequestParam(value = "id") int id) {
        return "admin/setTime";
    }
}
