package com.alexlin.controller;


import com.alexlin.model.Student;
import com.alexlin.model.Teacher;
import com.alexlin.service.StudentService;
import com.alexlin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @GetMapping("/demo")
    public ModelAndView demo() {
//        System.out.println("-----------findAll()-----------");
//        List<Teacher> teacherList = teacherService.findAll();
//        for(Teacher teacher:teacherList){
//            System.out.println(teacher.toString());
//        }

//        System.out.println("-----------------inserting---------------");
//        Teacher teacher = new Teacher();
//        teacher.setT_name("何老师");
//        teacher.setT_password("232fff");
//        int affectedRows = teacherService.addTeacher(teacher);
//        System.out.println(affectedRows+"rows been added");


//

//        System.out.println("--------------delete----------------");
//        int id = 1;
//        int affectRows = teacherService.deleteTeacher(id);
//        System.out.println(affectRows+"rows been deleted");

//        System.out.println("--------------update----------------");
//        int id=2;
//        Teacher teacher = new Teacher();
//        teacher.setT_id(id);
//        teacher.setT_name("俊豪老师");
//        teacher.setT_password("hello");
//        teacher.setS_count(20);
//        int affectRows = teacherService.updateTeacher(teacher);
//        System.out.println(affectRows+"rows been update");

//
//        System.out.println("--------------findTeacherById----------------");
//        int id=2;
//        Teacher teacher = teacherService.findTeacherById(id);
//        System.out.println(teacher.toString());



        /*---------------student---------------------*/
//        System.out.println("inserting");
//        Student student = new Student();
//        student.setS_name("张无f");
//        student.setS_password("22222");
//        student.setS_num(1927230202);
//        int affectedRows = studentService.addStudent(student);
//        System.out.println(affectedRows+"rows been affect");
//        System.out.println(student.toString());


//        System.out.println("--------------delete----------------");
//        int id = 5;
//        int affectRows = studentService.deleteStudent(id);
//        System.out.println(affectRows+"rows been deleted");

//        System.out.println("--------------update----------------");
//        int id=8;
//        Student student = new Student();
//        student.setS_id(id);
//        student.setS_name("wangdana");
//        student.setS_password("ddd");
//        student.setS_num(111);
//        student.setT_id(2);
//        int affectRows = studentService.updateStudent(student);
//        System.out.println(affectRows+"rows been update");
//

//        System.out.println("--------------findStudentById----------------");
//        int id=8;
//        Student student = studentService.findStudentById(id);
//        System.out.println(student.toString());


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo");
        return modelAndView;
    }
}
