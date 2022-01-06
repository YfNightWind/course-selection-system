<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2022/1/5
  Time: 14:55
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
    <title>学生选导师</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/studentSelect.css">
    <script src="/js/common.js"></script>
</head>

<body>
<jsp:include page="top.jsp">
    <jsp:param name="number" value="${number}"/>
</jsp:include>
<div class="main">
    <div class="header">
        <h3 class="title">
            选择导师
        </h3>
        <div class="search">
            <button onclick="submit(${s_id})">提交</button>
            <input type="text" placeholder="请输入查询条件">
            <button>查询</button>
        </div>
    </div>
    <div class="table">
        <div class="title">
            <div class="th">教师姓名</div>
            <div class="th">当前指导学生数</div>
            <div class="th">指导学生总名额</div>
            <div class="th">志愿选择</div>
        </div>
        <div class="main-table">
            <c:forEach items="${list}" var="teacher">
                <div class="tr tr-normal">
                    <input readonly id="username" class="td" value="${teacher.t_name}"></input>
                    <input readonly id="nowCount" class="td" value="${teacher.s_count}"></input>
                    <input readonly id="allCount" class="td" value="${teacher.s_max}"></input>
                    <div class="td td-normal-option">
                        <button class="v1">第一志愿</button>
                        <button class="v2">第二志愿</button>
                        <button class="v3">第三志愿</button>
                    </div>
                    <input id="userid" style="display: none;" value="${teacher.t_id}"></input>
                </div>

            </c:forEach>
        </div>

        <div class="tfooter">
            <div class="volunteers">
                <div class="v1-tfooter">第一志愿：<span id="v1">${v1TeacherName}</span></div>
                <div class="v2-tfooter">第二志愿：<span id="v2">${v2TeacherName}</span></div>
                <div class="v3-tfooter">第三志愿：<span id="v3">${v3TeacherName}</span></div>
            </div>
        </div>
    </div>

</div>

</body>
<script src="/js/studentSelect.js"></script>
</html>
