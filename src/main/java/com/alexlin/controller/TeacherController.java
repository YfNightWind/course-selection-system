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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;
    // 教师登录
    @PostMapping("/login")
    @ResponseBody
    public ReturnContent teacherLogin(@RequestParam(value = "name", defaultValue = "") String name,
                                      @RequestParam(value = "password", defaultValue = "") String password) {
        if (name.equals("") || password.equals("")) {
            return new ReturnContent(false, "参数必须填写！", "");
        }
        System.out.println("name:"+name+"password:"+password);
        Teacher teacher = teacherService.teacherLogin(name, password);
        System.out.println(teacher.toString());

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
    // 一志愿落选
    @PostMapping("/vOut")
    @ResponseBody
    public ReturnContent setVOut(@RequestParam(value = "s_id", defaultValue = "-1") int s_id) {

        if (s_id == -1) {
            return new ReturnContent(false, "参数必须填写", "");
        }
        Admin admin = adminService.getDate();
        int date = admin.getDate();
        //date==0表示进行第一志愿的选择
        if(date==0){
            if (studentService.setV1Out(s_id) == 0) {
                return new ReturnContent(false, "状态设置失败", "");
            } else {
                return new ReturnContent(true, "设置状态成功", "");
            }
        }else if(date==1){
            //date==1表示开始第二志愿的选择
            if (studentService.setV2Out(s_id) == 0) {
                return new ReturnContent(false, "状态设置失败", "");
            } else {
                return new ReturnContent(true, "设置状态成功", "");
            }
        }else if(date==2){
            //date==2表示进行第三志愿的选择
            if (studentService.setV3Out(s_id) == 0) {
                return new ReturnContent(false, "状态设置失败", "");
            } else {
                return new ReturnContent(true, "设置状态成功", "");
            }
        }

        return  new ReturnContent(true,"选择已结束","");
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
    @GetMapping("selectStudent")
    public String selectStudent(int t_id, ModelMap model){
        System.out.println(t_id);
        String title = "当前所有学生还未选择完毕";
        Admin admin = adminService.getDate();
        int date = admin.getDate();
        List<Student> studentList = null;
        if(date==-1){
            //此时学生还未选择完毕，导师还不可以进行选择
            studentList = new ArrayList<Student>();//给学生列表赋值为空
        }
        else if(date==0){
            title="第一志愿选择进行中";
            studentList = studentService.matchV1(t_id);//得到第一志愿是该老师的学生同时状态为Ready的学生
        }else if(date==1){
            title="第二志愿选择进行中";
            studentList = studentService.matchV2(t_id);//得到第二志愿是该老师的学生同时状态为V1Out的学生
        }else if(date==2){
            title="第三志愿选择进行中";
            studentList = studentService.matchV3(t_id);//得到第三志愿是该老师的学生同时状态为V2Out的学生
        }else{
            //此时要么差额补选，要么已经结束了
            title="志愿选择已结束";
            studentList = new ArrayList<Student>();//给学生列表赋值为空
        }

        model.addAttribute("list",studentList);
        model.addAttribute("title",title);
        Teacher teacher = teacherService.findTeacherById(t_id);
        model.addAttribute("teacher",teacher);
        return "teacher/teacherSelect";
    }
}
