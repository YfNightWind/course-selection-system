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
</head>
<body>
    <c:forEach items="${list}" var="Student">
        ${Student.s_id}--${Student.s_name}--${Student.s_password}<br>
    </c:forEach>
</body>
</html>
