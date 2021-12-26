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

<form>
    <input type="text"  name="name"> 姓名</input>
    <input type="password" name="password" >密码</input>
    <input type="submit">提交</input>
</form>





</body>

<%--这边尝试使用jQuery--%>


<script>
    var btn = document.getElementsByTagName('input')[2];
    btn.onclick = function() {
        // console.log(1);

        var xhr = new XMLHttpRequest();

        // 这边做数据的呈现
        var result = document.getElementById("result");
        // 再去设置result的文本

        xhr.open('GET', 'http://localhost:8080/student/login');

        xhr.send();

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                if (xhr.status >= 200 && xhr.status < 300) {
                    result.innerHTML = xhr.responseText;
                    console.log(xhr.response);
                    console.log(xhr.status);// 状态码
                }
            } else {
                alert(111);
            }
        }
    }
</script>
</html>
