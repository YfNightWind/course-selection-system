package com.alexlin.model;


public class Admin {
    private int a_id;
    private String a_name;
    private String a_password;
    private int date;

    public Admin(int a_id, String a_name, String a_password, int date) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_password = a_password;
        this.date = date;
    }

    public Admin() {
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "a_id=" + a_id +
                ", a_name='" + a_name + '\'' +
                ", a_password='" + a_password + '\'' +
                ", date=" + date +
                '}';
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }
}
