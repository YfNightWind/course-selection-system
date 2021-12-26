package com.alexlin.controller;

import com.alexlin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/demo")
    public ModelAndView demo(){
//        System.out.println("inserting");
//        Student student = new Student();
//        student.setS_name("张无f");
//        student.setS_password("22222");
//        student.setS_num(1927230202);
//
        //


//        System.out.println("--------------delete----------------");
//        int id = 6;
//        int affectRows = studentService.deleteStudent(id);
//        System.out.println(affectRows+"rows been deleted");

//        System.out.println("--------------update----------------");
//        int id=5;
//        Student student = new Student();
//        student.setS_id(id);
//        student.setS_name("wangdana");
//        student.setS_password("ddd");
//        student.setS_num(111);
//        int affectRows = studentService.updateStudent(student);
//        System.out.println(affectRows+"rows been dupdate");


//        System.out.println("--------------findStudentById----------------");
//        int id=5;
//        Student student = studentService.findStudentById(id);
//        System.out.println(student.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo");
        return modelAndView;
    }

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list",studentService.findAll());
        return modelAndView;
    }

}
