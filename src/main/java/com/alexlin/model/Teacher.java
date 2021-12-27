package com.alexlin.model;

public class Teacher {
    private int t_id;
    private String t_name;
    private String t_password;
    private int s_count=0;
    private int s_max=0;

    public int getS_max() {
        return s_max;
    }

    public void setS_max(int s_max) {
        this.s_max = s_max;
    }

    public int getS_count() {
        return s_count;
    }

    public void setS_count(int s_count) {
        this.s_count = s_count;
    }


    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", t_password='" + t_password + '\'' +
                ", s_count=" + s_count +
                ", s_max=" + s_max +
                '}';
    }
}
