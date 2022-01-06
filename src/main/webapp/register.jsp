<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/12/26
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/login.css">
    <script src="/js/common.js"></script>
    <title>注册</title>
</head>
<body>
<h1>注册</h1>
<div class="container">
    <div class="studentNumber"><input type="text" id="studentNumber" placeholder="请输入您学号"></div>
    <div class="name"><input type="text" id="name" placeholder="请输入您的用户名"></div>
    <div class="password"><input type="text" id="password" placeholder="请输入您的密码"></div>
    <div class="role">
        <label class="checkbox-inline">
            <input onclick="teacher()" type="radio" name="role" value="教师">教师
        </label>
        <label class="checkbox-inline">
            <input checked onclick="student()" type="radio" name="role" value="学生">学生
        </label>
        <div class="submit">
            <button type="submit" onclick="submit()">注册</button>
        </div>
    </div>

</div>
</body>
<script>
    //学生注册比教师注册多了一个输入字段
    function student() {
        var studentNumber = document.querySelector(".studentNumber");
        studentNumber.style.display = "block";
    }

    function teacher() {
        var studentNumber = document.querySelector(".studentNumber");
        studentNumber.style.display = "none";
    }

    function submit() {
        var roles = document.getElementsByName("role");
        var role = "";
        roles.forEach((rolebox) => {
            if (rolebox.checked) {
                role = rolebox.value;
                console.log(role);
            }
        })
        var data = {
            "name": document.getElementById("name").value,
            "studentNumber": document.getElementById("studentNumber").value,
            "password": document.getElementById("password").value
        }
        var url = "";
        if (role == "学生") {
            url = "student/register";
        } else if (role == "教师") {
            url = "teacher/register";
        }
        formPost(url, data, function (result) {
            if (result.code) {
                location.href = "/";
            } else {
                alert(result.msg);
            }
        })
    }
</script>
</html>
