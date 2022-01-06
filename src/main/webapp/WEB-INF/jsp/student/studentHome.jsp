<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2022/1/6
  Time: 0:04
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
    <title>学生主页</title>
    <link rel="stylesheet" href="/css/studentHome.css">
</head>
<style>
    h1,
    h2,
    h3,
    h4 {
        text-align: center;
    }
</style>
<body>
<jsp:include page="top.jsp">
    <jsp:param name="number" value="${number}"/>
</jsp:include>
<h1>学生${student.s_name}的主页</h1>
<h3>学号:${student.s_num}</h3>
<h3>导师:${teacherName}</h3>
<h3>第一志愿:${v1}</h3>
<h3>第二志愿:${v2}</h3>
<h3>第三志愿:${v3}</h3>
<h3>志愿选择情况:${state}</h3>
</body>
</html>
