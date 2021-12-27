package com.alexlin.controller;


import com.alexlin.dao.TeacherDao;
import com.alexlin.service.StudentService;
import com.alexlin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherDao teacherDao;

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



//        /*---------------student---------------------*/
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





//
//        System.out.println("--------------update----------------");
//        int id=1;
//        SelectInfo selectInfo = new SelectInfo();
//        selectInfo.setS_id(1);
//        selectInfo.setV1(1);
//        selectInfo.setV2(2);
//        selectInfo.setV3(3);
//        int affectRows = selectInfoService.updateSelectInfo(selectInfo);
//        System.out.println(affectRows+"rows been update");


//        System.out.println("--------------delete----------------");
//        int id = 1;
//        int affectRows = selectInfoService.deleteSelectInfo(id);
//        System.out.println(affectRows+"rows been deleted");

//        System.out.println("--------------findStudentById----------------");
//        int id=1;
//        SelectInfo selectInfo = selectInfoService.findSelectInfoById(id);
//        System.out.println(selectInfo.toString());
//
//                System.out.println("-----------findAll()-----------");
//        List<SelectInfo> selectInfoList = selectInfoService.findAll();
//        for(SelectInfo selectInfo2:selectInfoList){
//            System.out.println(selectInfo2.toString());
//        }

/*差额补选--------------------------------------------------------------------------------------------------*/
//        int t_id=studentService.byElection(4);
//        System.out.println("id为"+t_id+"的导师成为了该学生的老师");


/*设置学生状态--------------------------------------------------------------------------------------*/
//        studentService.setReady(10);
//        studentService.setV1Out(2);
//        studentService.setV2Out(4);
//        studentService.setV3Out(8);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo");
        return modelAndView;
    }
}
