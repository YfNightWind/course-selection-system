<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2022/1/6
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .top {
        display: flex;

    }

    .top > * {
        flex: 1;
    }

    .center_top {
        text-align: center;
    }

    .right_top {
        text-align: right;
    }
</style>
<body>
<div class="top">
    <div class="left_top">
        <a href='home?number=<%=request.getParameter("number")%>'>进入主页</a>
        <a href='selectTeacher?number=<%=request.getParameter("number")%>'>选择导师</a>
    </div>
    <div class="center_top">
        学生
    </div>
    <div class="right_top">
        <a href="/">退出</a>
    </div>
</div>
</body>
</html>
