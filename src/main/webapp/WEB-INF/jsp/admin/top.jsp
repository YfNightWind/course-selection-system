<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2022/1/6
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .top{
        display: flex;

    }
    .top>*{
        flex:1;
    }
    .center_top{
        text-align: center;
    }
    .right_top{
        text-align: right;
    }
</style>
<body>
<div class="top">
    <div class="left_top">
        <a href="showStudent">管理学生</a>
        <a href="showTeacher">管理导师</a>
        <a href="setTime?id=1">设置时间</a>
    </div>
    <div class="center_top">
        管理员
    </div>
    <div class="right_top">
        <a href="/">退出</a>
    </div>
</div>

</body>
</html>
