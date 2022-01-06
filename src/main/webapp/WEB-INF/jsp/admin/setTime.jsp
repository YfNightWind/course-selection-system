<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2022/1/6
  Time: 2:18
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
    <title>Document</title>
    <script src="/js/common.js"></script>
</head>
<style>
    .main {
        width: 600px;
        margin: 100px auto;
        text-align: center;
    }

    .submit {
        margin-top: 10px;
        text-align: center;
    }

    .submit button {
        width: 60px;
        border-radius: 5px;
    }
</style>

<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="main">
    <div class="v0">
        设置学生填报三个志愿截止时间为:
        <input type="date" id="v0Time" dateStyle="medium " pattern="yyyy-MM-dd " />
    </div>
    <div class="v1">
        设置导师选择第一志愿截止时间为:
        <input type="date" id="v1Time" dateStyle="medium " pattern="yyyy-MM-dd " />
    </div>
    <div class="v2">
        设置导师选择第二志愿截止时间为:
        <input type="date" id="v2Time" dateStyle="medium " pattern="yyyy-MM-dd " />
    </div>
    <div class="v3"> 设置导师选择第三志愿截止时间为:
        <input type="date" id="v3Time" dateStyle="medium " pattern="yyyy-MM-dd " />
    </div>
    <div class="byElection">
        设置学生进行差额补选截止时间为:
        <input type="date" id="byElection" dateStyle="medium " pattern="yyyy-MM-dd " />
    </div>
    <div class="submit">
        <button onclick="submit()">提交</button>
    </div>

</div>




</body>
<script src="/js/setTime.js"></script>
</html>
