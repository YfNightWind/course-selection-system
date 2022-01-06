package com.alexlin.service.impl;

import com.alexlin.dao.AdminDao;
import com.alexlin.dao.StudentDao;
import com.alexlin.model.Admin;
import com.alexlin.model.Student;
import com.alexlin.service.AdminService;
import com.alexlin.service.StudentService;
import com.alexlin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherService teacherService;
    @Override
    public Admin adminLogin(String name, String password) {
        return adminDao.adminLogin(name, password);
    }

    @Override
    public Admin getDate() {
        return adminDao.getDate();
    }

    @Override
    public int setReady() {
        //将当前的时间改为学生开始选课状态
        adminDao.modifyDate(0);

        //将所有学生的状态改为Ready
        return studentDao.setAll("Ready");

    }
    @Override
    public int setStart(){
        //将当前的时间改为学生开始选课状态
        adminDao.modifyDate(-1);

        //将所有学生的状态改为Ready
        return studentDao.setAll("Start");
    }

    @Override
    public int setV1Out() {
        //1表示第一志愿截止，开始第二志愿选择
        adminDao.modifyDate(1);

        return studentDao.setVOut("V1Out");
    }

    @Override
    public int setV2Out() {
        //2表示第二志愿截止，开始第三志愿选择
        adminDao.modifyDate(2);

        return studentDao.setVOut("V2Out");
    }

    @Override
    public int setV3Out() {
        //3表示第三志愿截止，开始差额补选
        adminDao.modifyDate(3);

        return studentDao.setVOut("V3Out");
    }
    /*
    @Override
    public void setTeacher(int s_id, int t_id) {
        Student student = new Student();
        student.setState("Finish");
        student.setT_id(t_id);
        student.setS_id(s_id);
        studentDao.setTeacher(student);
        teacherDao.addScount(t_id);
    }
*/

    @Override
    public int byElectionAll() {
        //得到所有未确定导师的学生
        List<Student> studentList = studentDao.getAllNotFinish();
        //对他们进行差额补选
        for(Student student :studentList){
            teacherService.byElection(student.getS_id());
        }
        //4表示学生进行差额补选完成
        adminDao.modifyDate(4);
        return studentList.size();
    }

}
