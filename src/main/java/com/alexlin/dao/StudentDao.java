package com.alexlin.dao;

import com.alexlin.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
<<<<<<< HEAD
    Student studentLogin(String name, String password);
    public List<Student> findAll();
    public int addStudent(Student student);
    public int deleteStudent(int s_id);
    public int updateStudent(Student student);
    public Student findStudentById(int id);
    public int setTeacher(Student student);
    public void setState(Student student);
=======
    List<Student> findAll();
    Student studentLogin(@Param("name") String name, @Param("password") String password);
    int addStudent(Student student);
    int deleteStudent(int s_id);
    int updateStudent(Student student);
    Student findStudentById(int id);
>>>>>>> e9f212da5288147a825f2f54c165b0b0e58b6791
}
