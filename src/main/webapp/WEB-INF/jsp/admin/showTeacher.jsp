<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2022/1/3
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理教师</title>
    <link rel="stylesheet" href="/css/managerStudent.css">
</head>
<body>
<div class="main">
    <div class="header">
        <h3 class="title">
            教师管理
        </h3>
        <div class="search">
            <input type="text" placeholder="请输入查询条件"><button>查询</button>
        </div>
    </div>
    <div class="table">
        <div class="title">
            <div class="th">教师姓名</div>
            <div class="th">密码</div>
            <div class="th">当前指导学生数</div>
            <div class="th">指导学生总名额</div>
            <div class="th">修改</div>
            <div class="th">删除</div>
        </div>
        <c:forEach items="${list}" var="teacher">
            <div class="tr">
                <div class="td">${teacher.t_name}</div>
                <div class="td">${teacher.t_password}</div>
                <div class="td">${teacher.s_count}</div>
                <div class="td">${teacher.s_max}</div>
                <div class="td"><button onClick="location.href='updateTeacher?id=${teacher.t_id}'">修改</button></div>
                <div class="td"><button>删除</button></div>
            </div>
        </c:forEach>

        <div class="tfooter">
            <div class="amount">当前<span class="current_page">1</span>页, 总
                <span class="num_recoder">7</span>条记录
            </div>
            <div class="page_turn">
                <button class="previous">上一页</button>
                <button class="num_page">1</button>
                <button class="num_page">2</button>
                <button class="next">下一页</button>
            </div>
        </div>
    </div>

</div>
</body>
</html>
