package com.alexlin.model;

public class Student {
    private int s_id;
    private String s_name;
    private String s_password;
    private int s_num;
    private int t_id=0;

    public int getS_num() {
        return s_num;
    }

    public void setS_num(int s_num) {
        this.s_num = s_num;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public Student(int s_id, String s_name, String s_password) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_password = s_password;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_password='" + s_password + '\'' +
                ", s_num=" + s_num +
                ", t_id=" + t_id +
                '}';
    }

    public Student() {
    }
}
