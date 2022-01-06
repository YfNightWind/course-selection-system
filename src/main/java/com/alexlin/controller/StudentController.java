package com.alexlin.controller;

import com.alexlin.model.Student;
import com.alexlin.model.Teacher;
import com.alexlin.service.StudentService;
import com.alexlin.service.TeacherService;
import com.alexlin.utils.ReturnContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

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

    //学生主页,登录成功则改学号必有其人
    @GetMapping("/home")
    public String home(ModelMap model, String number) {
        Student student = studentService.findStudentByNumber(number);
        System.out.println(student.toString());
        String teacherName = "未确定";
        String state = "学生选择志愿中";
        String v1 = "未确定";
        String v2 = "未确定";
        String v3 = "未确定";
        //确定志愿的老师的名字
        if (student.getV1() != 0) {
            Teacher teacher = teacherService.findTeacherById(student.getV1());
            v1 = teacher.getT_name();
        }
        if (student.getV2() != 0) {
            Teacher teacher = teacherService.findTeacherById(student.getV2());
            v2 = teacher.getT_name();
        }
        if (student.getV3() != 0) {
            Teacher teacher = teacherService.findTeacherById(student.getV3());
            v3 = teacher.getT_name();
        }
        //确定导师的名字
        if (student.getT_id() != 0) {
            Teacher teacher = teacherService.findTeacherById(student.getT_id());
            teacherName = teacher.getT_name();
        }
        //确定状态
        if (student.getState().equals("Start")) {
            state = "选择志愿中";
        } else if (student.getState().equals("Ready")) {
            state = "第一志愿老师选择中";
        } else if (student.getState().equals("V1Out")) {
            state = "第一志愿落选";
        } else if (student.getState().equals("V2Out")) {
            state = "第二志愿落选";
        } else if (student.getState().equals("V3Out")) {
            state = "第三志愿落选";
        } else if (student.getState().equals("Finish")) {
            state = "志愿选择结束，已选择导师";
        }
        model.addAttribute("number", number);
        model.addAttribute("student", student);
        model.addAttribute("teacherName", teacherName);
        model.addAttribute("state", state);
        model.addAttribute("v1", v1);
        model.addAttribute("v2", v2);
        model.addAttribute("v3", v3);
        return "student/studentHome";
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
    public ReturnContent setTeacher(@RequestBody Student student) {
        /*
          应该传递四个参数，v1，v2，v3和学生的id，同时设置状态为ready
         */
        System.out.println(student);
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


    @GetMapping("/selectTeacher")
    public String selectTeacher(ModelMap model, @RequestParam("number") String number) {
        Student student = studentService.findStudentByNumber(number);
        List<Teacher> list = teacherService.findAll();
        //学生志愿的老师名字
        String v1Teacher = "未确定";
        String v2Teacher = "未确定";
        String v3Teacher = "未确定";
        System.out.println(student.toString());
        if (student.getV1() != 0) {
            v1Teacher = teacherService.findTeacherById(student.getV1()).getT_name();
        }
        if (student.getV2() != 0) {
            v2Teacher = teacherService.findTeacherById(student.getV2()).getT_name();
        }
        if (student.getV3() != 0) {
            v3Teacher = teacherService.findTeacherById(student.getV3()).getT_name();
        }
        model.addAttribute("number", number);
        model.addAttribute("v1TeacherName", v1Teacher);
        model.addAttribute("v2TeacherName", v2Teacher);
        model.addAttribute("v3TeacherName", v3Teacher);
        model.addAttribute("s_id", student.getS_id());
        model.addAttribute("list", list);
        return "/student/studentSelect";
    }

}

