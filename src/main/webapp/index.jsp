<%--
  Created by IntelliJ IDEA.
  User: alexlin
  Date: 2021/12/14
  Time: 00:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Title</title>
    <link rel="stylesheet" href="/css/login.css">
    <script src="/js/common.js"></script>
    <title>登录</title>
</head>

<body>
<h1>登录</h1>
<div class="container">
    <div class="name"><input type="text" id="name" placeholder="请输入您的用户名"></div>
    <div class="password"><input type="password" id="password" placeholder="请输入您的密码"></div>
    <div class="role">
        <label class="checkbox-inline">
            <input type="radio" name="role" value="管理员" checked>管理员
        </label>
        <label class="checkbox-inline">
            <input onclick="teacher()" type="radio" name="role" value="教师">教师
        </label>
        <label class="checkbox-inline">
            <input checked onclick="student()" type="radio" name="role" value="学生">学生
        </label>
        <div class="submit">
            <button type="submit" onclick="login()" id="button">登录</button>
        </div>
        <a href="register.jsp">点击注册</a>
    </div>

</div>

</body>


<script>

    function login() {
        var notTeacher = true;
        var roles = document.getElementsByName("role");
        var role = "";
        roles.forEach((rolebox) => {
            if (rolebox.checked) {
                role = rolebox.value;
                console.log(role);
            }
        })
        var data = {
            "number": document.getElementById("name").value,
            "password": document.getElementById("password").value
        }
        var url = "";
        var jumpUrl = "";
        if (role == "学生") {
            url = "student/login";
            jumpUrl = "student/selectTeacher?number=" + data.number;
        } else if (role == "管理员") {
            data.name = data.number;
            url = "admin/login";
            jumpUrl = "admin/showTeacher";
        } else if (role == "教师") {
            notTeacher = false;
            url = "teacher/login";

            data.name = data.number;
            formPost(url, data, function (result) {
                if (result.code) {
                    jumpUrl = "teacher/selectStudent?t_id=" + result.result.t_id;
                    location.href = jumpUrl;
                } else {
                    alert(result.msg);
                }
            })
        }
        //教师需要拿到返回的值中的id属性，所以要特殊对待
        if (notTeacher) {
            formPost(url, data, function (result) {
                if (result.code) {
                    location.href = jumpUrl;
                } else {
                    alert(result.msg);
                }
            })
        }

    }
</script>
</html>
