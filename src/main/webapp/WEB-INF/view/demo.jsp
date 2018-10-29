<%--
  Created by IntelliJ IDEA.
  User: zq
  Date: 2018/10/28/028
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>                                           <!--传文件一定要注意 -->
<form method="post" action="/user/upload" enctype="multipart/form-data">
    <input type="text" name="id">
    <input type="file" name="file"> <!-- 名称和后台的传递参数一样才行-->
    <input type="file" name="file">
    <input type="file" name="file">  <!-- 多个文件-->
    <input type="submit" value="提交">
    <a href="/user/down">xiazai</a>
</form>
</body>
</html>

