package com.alexlin.model;

public class Student {
    private int s_id;
    private String s_name;
    private String s_password;
    private int s_num;
    private int t_id=0;
    private String state="Start";
    private int v1=0;
    private int v2=0;
    private int v3=0;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    public int getV3() {
        return v3;
    }

    public void setV3(int v3) {
        this.v3 = v3;
    }

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
                ", state='" + state + '\'' +
                ", v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                '}';
    }

    public Student() {
    }
}
