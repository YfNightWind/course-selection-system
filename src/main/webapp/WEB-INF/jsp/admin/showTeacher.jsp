<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2022/1/3
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理教师</title>
    <link rel="stylesheet" href="/css/manageStudent.css">
    <script src="/js/common.js"></script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="main">
    <div class="header">
        <h3 class="title">
            教师管理
        </h3>
        <div class="search">
            <button onclick="add()">+</button>
            <input type="text" placeholder="请输入查询条件">
            <button>查询</button>
        </div>
    </div>
    <div class="table">
        <div class="title">
            <div class="th">教师姓名</div>
            <div class="th">密码</div>
            <div class="th">当前指导学生数</div>
            <div class="th">指导学生总名额</div>
            <div class="th">操作</div>
        </div>
        <div class="main-table">
            <c:forEach items="${list}" var="teacher">
                <div class="tr tr-normal">
                    <input readonly id="username" class="td" value="${teacher.t_name}"></input>
                    <input readonly id="password" class="td" value="${teacher.t_password}"></input>
                    <input readonly id="nowCount" class="td" value="${teacher.s_count}"></input>
                    <input readonly id="allCount" class="td" value="${teacher.s_max}"></input>
                    <div class="td td-normal-option">
                        <button class="modify">修改</button>
                        <button class="delete">删除</button>
                    </div>
                    <div class="td hide td-modify-option">
                        <button class="submit">提交</button>
                        <button class="cancel">取消</button>
                    </div>
                    <input id="userid" style="display: none;" value="${teacher.t_id}"></input>
                </div>
            </c:forEach>
        </div>
    </div>

</div>

</body>
<script src="/js/manageTeacher.js"></script>
</html>
