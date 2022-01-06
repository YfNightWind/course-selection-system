<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2022/1/5
  Time: 19:51
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
    <title>学生选导师</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/studentSelect.css">
    <link rel="stylesheet" href="/css/teacherSelect.css">
    <script src="/js/common.js"></script>
</head>

<body>
<jsp:include page="top.jsp"></jsp:include>
<h1>${title}</h1>
<div class="main">
    <div class="header">
        <h3 class="title">
            选择学生
        </h3>
        <div class="search">
            <input type="text" placeholder="请输入查询条件">
            <button>查询</button>
        </div>
    </div>
    <div class="table">
        <div class="title">
            <div class="th">学生姓名</div>
            <div class="th">当前指导学生数</div>
            <div class="th">指导学生总名额</div>
            <div class="th">选择学生</div>
        </div>
        <div class="main-table">
            <c:forEach items="${list}" var="student">
                <div class="tr tr-normal">
                    <input readonly  class="td" value="${student.s_name}"></input>
                    <input readonly  class="td" value="${teacher.s_count}"></input>
                    <input readonly  class="td" value="${teacher.s_max}"></input>
                    <div class="td td-normal-option">
                        <button onclick="select(${teacher.t_id},${student.s_id})">选择该生</button>
                        <button onclick="out(${student.s_id})">放弃该生</button>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="tfooter">

        </div>
    </div>
</div>
</body>
<script src="/js/teacherSelect.js"></script>

</html>
